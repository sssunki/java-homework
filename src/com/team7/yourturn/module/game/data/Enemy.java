package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.GameWindow;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;
import com.team7.yourturn.module.game.collision.CollisionEvent;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.team7.yourturn.module.game.GameController.enemyExist;
import static com.team7.yourturn.module.game.GameController.score;
import static com.team7.yourturn.utils.EventCode.*;

public class Enemy extends BaseViewModel implements Movable, Damageable {

    private EnemyGeneratePoint parentGeneratePoint;
    public Queue<Integer> enemyEventQueue;
    private GameController gameController;

    private int enemyId;
    private int direction =10002;
    private int hp;

    public Enemy(int x, int y, EnemyGeneratePoint parentGeneratePoint) {
        this.x = x;
        this.y = y;
        this.hp = 10;
        this.parentGeneratePoint = parentGeneratePoint;
        this.enemyEventQueue = new LinkedBlockingQueue<>();
        this.itemComponent = new ItemComponent("enemy1.jpg",width,height);
    }

    public Enemy(int x, int y, EnemyGeneratePoint parentGeneratePoint,GameController gameController) {
        this.x = x;
        this.y = y;
        this.hp = 10;
        this.itemComponent = new ItemComponent("enemy1.jpg",width,height);
        this.parentGeneratePoint = parentGeneratePoint;
        this.enemyEventQueue = new LinkedBlockingQueue<>();
        this.gameController = gameController;
    }


    public void addEvent(int eventCode) {
        enemyEventQueue.offer(eventCode);
    }

    public void start() {

        GenerateEvent generateEvent = new GenerateEvent();
        Thread thread = new Thread(generateEvent,"enemyEvent");
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int eventCode;
                    if (!enemyEventQueue.isEmpty()) {
                        eventCode = enemyEventQueue.poll();
                        if (eventCode == ENEMY_ITEM_DEATH ) {
                            break;
                        }else
                            handleEvent(eventCode);
                    }
                }
            }
        }).start();
    }

    private class GenerateEvent implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    generateEventCode();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private int generateEventCode() {
            int eventCodeSeed = (int)(1+Math.random()*(5-1+1));
            switch (eventCodeSeed) {
                case 1:
                    enemyEventQueue.offer(ITEM_MOVE_DOWN);
                    break;
                case 2:
                    enemyEventQueue.offer(ITEM_MOVE_UP);
                    break;
                case 3:
                    enemyEventQueue.offer(ITEM_MOVE_RIGHT);
                    break;
                case 4:
                    enemyEventQueue.offer(ITEM_MOVE_LEFT);
                    break;
//                case 5:
//                    enemyEventQueue.offer(ITEM_ATTACK);
//                    break;
                default:
                    break;
            }
            return 0;
        }
    }



    public int handleEvent(int eventCode) {
        switch (eventCode) {
            case ITEM_MOVE_DOWN:
            case ITEM_MOVE_UP:
            case ITEM_MOVE_LEFT :
            case ITEM_MOVE_RIGHT :
                int attackCodeSeed = (int)(1+Math.random()*(3-1+1));
                if(attackCodeSeed == 1){
                    Bullet bullet = new Bullet(direction,x,y, gameController);
                    bullet.draw();
                    bullet.move();
                }
                for (int i = 0; i <= 5; i++) {
                    try {
                        Thread.sleep(200);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    changeLocationAndDirection(eventCode);
                }
                return changeLocationAndDirection(eventCode);
            case ITEM_ATTACK  :

            case DAMAGE:
                onBeingAttacked();
                return EVENT_HANDLE_SUCCEED;
            case ENEMY_ITEM_DEATH:

            default:
                return CASE_WONT_HAPPEN;
        }
    }

    private int changeLocationAndDirection(int eventCode) {
        int xLast = x;
        int yLast = y;
        switch (eventCode) {

            case ITEM_MOVE_UP:
                y -= 30;
//                System.out.println(collisionDetection());
                if (collisionDetection() || edgeDetection()) {
                    y = yLast;
                } else {
                    locationUpdate();
                    directUpdateU(this.direction);
                    direction = DIRECT_UP;
                }
                return EVENT_HANDLE_SUCCEED;

            case ITEM_MOVE_DOWN:
                y += 30;
//                System.out.println(collisionDetection());
                if (collisionDetection() || edgeDetection()) {
                    y = yLast;
                } else {
                    locationUpdate();
                    directUpdateD(this.direction);
                    direction = DIRECT_DOWN;
                }
                return EVENT_HANDLE_SUCCEED;

            case ITEM_MOVE_RIGHT :
                x += 30;
//                System.out.println(collisionDetection());
                if (collisionDetection() || edgeDetection()) {
                    x = xLast;
                } else {
                    locationUpdate();
                    directUpdateR(this.direction);
                    direction = DIRECT_RIGHT;
                }
                return EVENT_HANDLE_SUCCEED;

            case ITEM_MOVE_LEFT :
                x -= 30;
//                System.out.println(collisionDetection());
                if (collisionDetection() || edgeDetection()) {
                    x = xLast;
                } else {
                    locationUpdate();
                    directUpdateL(this.direction);
                    direction = DIRECT_LEFT;
                }
                return EVENT_HANDLE_SUCCEED;

        }
        return CASE_WONT_HAPPEN;
    }

    public boolean edgeDetection() {
        if (x < 0 || x + width > 1000 || y < 0 || y + height > 800) {
            return true;
        }
        return false;
    }

    @Override
    public boolean collisionDetection() {
        boolean result = false;

        for (Item item : gameController.getCheckpointMap().getBarriers()) {
            // the coordinate of next step
            if (item == this){
                continue;
            }
            int targetX = item.getX();
            int targetY = item.getY();

            // detect collision
            if  (
                    ((x >= targetX && x< (targetX + item.getWidth())) && (y >=  targetY && y < (targetY + item.getHeight())) )
                            || ((x + width >= targetX && x + width < (targetX + item.getWidth())) && (y >=  targetY && y < (targetY + item.getHeight())) )
                            || ((x >= targetX && x < (targetX + item.getWidth())) && (y + height >=  targetY && y + height < (targetY + item.getHeight())) )
                            || ((x + width >= targetX && x + width < (targetX + item.getWidth())) && (y + height >=  targetY && y + height < (targetY + item.getHeight())) )
//                    (x >= targetX && x < (targetX + item.getWidth())) &&
//                    (y >=  targetY && y < (targetY + item.getHeight()))
            ) {
//                CollisionEvent collisionEvent = new CollisionEvent(this, targetX, targetY);
//                gameController.getCollisionHandler().addCollisionEvent(collisionEvent);
                result = true;
                break;
            }
        }

        return result;
    }

    private final int DIRECT_UP = 10001;
    private final int DIRECT_DOWN = 10002;
    private final int DIRECT_LEFT = 10003;
    private final int DIRECT_RIGHT = 10004;

    @Override
    public void onCollision() {
        onBeingAttacked();
    }

    @Override
    public void onBeingAttacked() {
        hp = hp-10;
        if (hp == 0){
            delete();
        }
    }

    public void delete(){
        enemyExist--;
        score += 100;
        System.out.println("enemy :" + enemyExist + "  \nscore :" + score);
        GameWindow gameWindow = GameWindow.getInstance();
        gameWindow.remove(itemComponent);
        gameController.deleteItem(this);
    }


}

