package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.game.GameController;

import java.awt.event.KeyEvent;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.team7.yourturn.utils.EventCode.*;

public class Enemy extends BaseViewModel implements Movable {

    private EnemyGeneratePoint parentGeneratePoint;
    private int enemyId;
    private int direction;
    private int hp = 50;
    private GameController gameController;
    public Queue<Integer> enemyEventQueue;

    public Enemy(int x, int y, EnemyGeneratePoint parentGeneratePoint) {
        this.x = x;
        this.y = y;
        this.parentGeneratePoint = parentGeneratePoint;
        this.enemyEventQueue = new LinkedBlockingQueue<>();
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
                addEvent(ITEM_ATTACK);

            }
        }
    }

    public int handleEvent(int eventCode) {
        switch (eventCode) {
            case ITEM_ATTACK:
                Bullet bullets = new Bullet(direction,x,y,gameController);
                bullets.draw();
                bullets.move();
            case ITEM_MOVE_DOWN:
            case ITEM_MOVE_LEFT:
            case ITEM_MOVE_RIGHT:
            case ITEM_MOVE_UP:
            case ENEMY_DAMAGED:
                hp -= 10;
                if(hp == 0){
                    return ENEMY_ITEM_DEATH;
                }
            default:
                return CASE_WONT_HAPPEN;
        }
    }

    private int changeLocationAndDirection(int eventCode) {
        switch (eventCode) {
            case ITEM_MOVE_UP:
                y -= 30;
                locationUpdate();
                direction = DIRECT_UP;
                return EVENT_HANDLE_SUCCEED;
            case ITEM_MOVE_DOWN:
                y += 30;
                locationUpdate();
                direction = DIRECT_DOWN;
                return EVENT_HANDLE_SUCCEED;
            case ITEM_MOVE_RIGHT:
                x += 30;
                locationUpdate();
                direction = DIRECT_RIGHT;
                return EVENT_HANDLE_SUCCEED;
            case ITEM_MOVE_LEFT:
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
}
