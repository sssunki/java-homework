package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;
import com.team7.yourturn.module.game.collision.CollisionEvent;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.team7.yourturn.utils.EventCode.*;

public class Enemy extends BaseViewModel implements Movable, Damageable {

    private EnemyGeneratePoint parentGeneratePoint;
    public Queue<Integer> enemyEventQueue;
    private GameController gameController;

    private int enemyId;
    private int direction;
    private int hp;

    public Enemy(int x, int y, EnemyGeneratePoint parentGeneratePoint) {
        this.x = x;
        this.y = y;
        this.hp = 10;
        this.parentGeneratePoint = parentGeneratePoint;
        this.enemyEventQueue = new LinkedBlockingQueue<>();
        this.itemComponent = new ItemComponent("test.jpg",width,height);
    }

    public Enemy(int x, int y, EnemyGeneratePoint parentGeneratePoint,GameController gameController) {
        this.x = x;
        this.y = y;
        this.hp = 10;
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
                    Thread.sleep(3000);
                    generateEventCode();
                }catch (Exception e) {
                    e.printStackTrace();
                }
//                addEvent(ITEM_ATTACK);
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
                case 5:
                    enemyEventQueue.offer(ITEM_ATTACK);
                    break;
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
                for (int i = 0; i <= 5; i++) {
                    try {
                        Thread.sleep(600);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    changeLocationAndDirection(eventCode);
                }
                return changeLocationAndDirection(eventCode);
            case ITEM_ATTACK  :

                Bullet bullet = new Bullet(direction,x,y, gameController);
                bullet.draw();
                bullet.move();
            case DAMAGE:
                onBeingAttacked();
                return EVENT_HANDLE_SUCCEED;
            //case ENEMY_ITEM_DEATH:

            default:
                return CASE_WONT_HAPPEN;
        }
    }

    private int changeLocationAndDirection(int eventCode) {
        switch (eventCode) {
            case ITEM_MOVE_UP:
                if(collisionDetection()){
                    break;
                }
                y -= 30;
                locationUpdate();
                direction = DIRECT_UP;
                return EVENT_HANDLE_SUCCEED;
            case ITEM_MOVE_DOWN:
                if(collisionDetection()){
                    break;
                }
                y += 30;
                locationUpdate();
                direction = DIRECT_DOWN;
                return EVENT_HANDLE_SUCCEED;
            case ITEM_MOVE_RIGHT :
                if(collisionDetection()){
                    break;
                }
                x += 30;
                locationUpdate();
                direction = DIRECT_RIGHT;
                return EVENT_HANDLE_SUCCEED;
            case ITEM_MOVE_LEFT :
                if(collisionDetection()){
                    break;
                }
                x -= 30;
                locationUpdate();
                direction = DIRECT_LEFT;
                return EVENT_HANDLE_SUCCEED;
        }
        return CASE_WONT_HAPPEN;
    }
    @Override
    public boolean collisionDetection() {
        return false;
    }

    private final int DIRECT_UP = 10001;
    private final int DIRECT_DOWN = 10002;
    private final int DIRECT_LEFT = 10003;
    private final int DIRECT_RIGHT = 10004;

    @Override
    public void onBeingAttacked() {
        hp = hp-10;
        if (hp < 0){
            //死亡
        }else{
            //更新血量
        }
    }

}

