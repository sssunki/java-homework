package com.team7.yourturn.module.game;

import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.data.map.CheckpointMap;
import com.team7.yourturn.data.map.CheckpointOne;
import com.team7.yourturn.data.map.CheckpointThree;
import com.team7.yourturn.data.map.CheckpointTwo;
import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.BaseView;
import com.team7.yourturn.module.base.GameWindow;
import com.team7.yourturn.module.game.collision.CollisionEvent;
import com.team7.yourturn.module.game.data.*;
import com.team7.yourturn.utils.Bundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

import static com.team7.yourturn.utils.EventCode.*;

public class GameController extends BaseController {


    private Bundle bundle;
    private int numOfPlayer;
    private int checkpoint;

    private CheckpointMap checkpointMap;
    private static int enemyLeft = 1;
    private List<EnemyGeneratePoint> enemyGeneratePoints;

    private CollisionHandler collisionHandler;
    private Player player;
    private volatile Player playerCopy;
    private List<Enemy> enemies;
    private List<Item> items;

    public CollisionHandler getCollisionHandler() {
        return collisionHandler;
    }

    public CheckpointMap getCheckpointMap() {
        return checkpointMap;
    }

    public GameController(Bundle bundle) {
        super(bundle);
    }

    public GameController(){

    }

    @Override
    protected void initEvent() {
        gameWindow.addKeyListener(new PlayerActionListener(this));
        EnemyGeneratePoint generatePoint = new EnemyGeneratePoint(0,0,this);
        generatePoint.start();
        collisionHandler = new CollisionHandler();
        collisionHandler.start();
    }

    @Override
    protected void initView() {
        player = new Player("player1.jpg",400,700,this);
        enemyGeneratePoints = new ArrayList<>();
        enemyGeneratePoints.add(new EnemyGeneratePoint(200, 100, this));
        enemyGeneratePoints.add(new EnemyGeneratePoint(500, 100, this));
        enemyGeneratePoints.add(new EnemyGeneratePoint(800, 100, this));
        enemies = new ArrayList<>();
        player.draw();
        initMap();
//        initEnemy();
    }

    private void initMap() {
        checkpointMap = new CheckpointThree();
        checkpointMap.setController(this);
        checkpointMap.mapInit();
        items = checkpointMap.getBarriers();
        for (Item item : items) {
            ((BaseView) item).draw();
        }

        playerCopy = generatePlayerCopy();
        items.add(playerCopy);
    }

    public void deleteItem(Item item) {
        items.remove(item);
    }

    private void initEnemy() {
        int i = (int)(1+Math.random()*(3-1+1));

        Enemy enemy = new Enemy(enemyGeneratePoints.get(i - 1).getX(),
                enemyGeneratePoints.get(i - 1).getY(),enemyGeneratePoints.get(i - 1), this);
        enemies.add(enemy);
        items.add(enemy);
        enemy.draw();
        enemy.start();
    }

    private Player generatePlayerCopy() {
        return new Player("player1.jpg",player.getX(),player.getY(),this);
    }

    @Override
    protected int handleEvent(int eventCode) {

        int returnCode = CASE_WONT_HAPPEN;

        switch(eventCode){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                items.remove(playerCopy);
                returnCode = player.handleEvent(eventCode);
                playerCopy = generatePlayerCopy();
                items.add(playerCopy);
                break;

            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_SPACE:
                Bullet bullet = new Bullet(player.getDirection(),player.getX(),player.getY(), this);
                bullet.draw();
                bullet.move();
                returnCode = EVENT_HANDLE_SUCCEED;
                break;

            case GENERATE_AN_ENEMY:
                initEnemy();
                returnCode = EVENT_HANDLE_SUCCEED;
                break;
        }

        return returnCode;
    }

    public static synchronized int getEnemyLeft() {
        return enemyLeft;
    }

    public static synchronized void setEnemyLeft(int e) {
        enemyLeft = e;
    }

    public synchronized boolean generateEnemy() {
        if (enemyLeft != 0) {
            addEvent(GENERATE_AN_ENEMY);
        }

        return false;
    }

    public synchronized void declineEnemyLeft() {
        enemyLeft--;
    }

    @Override
    protected void gotoNextPage() {

    }

    public class CollisionHandler{

        private Queue<CollisionEvent> collisionEventsQueue;

        public Queue<CollisionEvent> getCollisionEventsQueue() {
            return collisionEventsQueue;
        }

        public CollisionHandler() {
            collisionEventsQueue = new LinkedList<>();
        }

        public void addCollisionEvent(CollisionEvent collisionEvent) {
            collisionEventsQueue.offer(collisionEvent);
        }

        public void start() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("handler start");
                    while (true) {
//                        try {
//                            Thread.sleep(300);
//                        }catch (Exception e) {
//                            e.printStackTrace();
//                        }
                        System.out.println("queue empty: " + collisionEventsQueue.isEmpty());
                        if (!collisionEventsQueue.isEmpty()) {
                            System.out.println("testtest");
                            // get collision event
                            CollisionEvent collisionEvent = collisionEventsQueue.poll();

                            // init the consumer and producer
                            Item consumerItem = collisionEvent.getConsumers();
                            Item producerItem = collisionEvent.getProducer();
//                            for (Item item: items) {
//                                if ((item.getX() == collisionEvent.getConsumerX()) &&
//                                        (item.getY() == collisionEvent.getConsumerY())) {
//                                    consumerItem = item;
//                                }
//                            }
//
//                             call consumer's and producer's onCollision method.
//                            if (consumerItem != null) {
                                // judge null
                            System.out.println(consumerItem instanceof NormalWall);
                                consumerItem.onCollision();
//                            }
                            if (!(producerItem instanceof Bullet && consumerItem instanceof BulletThroughWall)) {
                                producerItem.onCollision();
                            }
                        }
                    }
                }
            }).start();
        }

    }
}
