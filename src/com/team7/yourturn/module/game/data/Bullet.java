package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;
import com.team7.yourturn.module.game.collision.CollisionEvent;

import static com.team7.yourturn.utils.EventCode.*;
import static com.team7.yourturn.utils.EventCode.ITEM_MOVE_LEFT;

public class Bullet extends BaseViewModel implements Movable , Damageable {

    private int direction;
    private GameController controller;
    int moveFlag;

    public Bullet(int direction, int x, int y, GameController controller) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.controller = controller;
        moveFlag = 0;
        itemComponent = new ItemComponent("bullet .jpg", 20, 20);
    }

    public void move() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                confirmDirection(direction);
                while(!collisionDetection()) {
                    try {
                        Thread.sleep(30);
                        switch (direction) {
                            case DIRECT_UP:
                                y -= 10;
                                break;
                            case DIRECT_DOWN:
                                y += 10;
                                break;
                            case DIRECT_RIGHT :
                                x += 10;
                                break;
                            case DIRECT_LEFT :
                                x -= 10;
                                break;
                        }
                        locationUpdate();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                delete();
            }
        }).start();
    }

    private void confirmDirection(int  direction){
        switch (direction) {
            case DIRECT_UP:
                break;
            case DIRECT_DOWN:
                directUpdateR(direction);
                directUpdateR(direction);
                break;
            case DIRECT_RIGHT :
                directUpdateD(direction);
                break;
            case DIRECT_LEFT :
                directUpdateD(direction);
                break;
        }
    }

    private void delete() {
        gameWindow.remove(itemComponent);

    }


    @Override
    public boolean collisionDetection() {
        boolean result = false;
        for (Item item : controller.getCheckpointMap().getBarriers()) {
            // the coordinate of next step
            if (moveFlag < 10) {
                moveFlag++;
                break;
            }
            int targetX = item.getX();
            int targetY = item.getY();

            // detect collision
            if  (
//                    ((x >= targetX && x< (targetX + item.getWidth())) && (y >=  targetY && y < (targetY + item.getHeight())) )
//                            || ((x + width >= targetX && x + width < (targetX + item.getWidth())) && (y >=  targetY && y < (targetY + item.getHeight())) )
//                            || ((x >= targetX && x < (targetX + item.getWidth())) && (y + height - 30>=  targetY && y + height - 30< (targetY + item.getHeight())) )
//                            || ((x + width >= targetX && x + width < (targetX + item.getWidth())) && (y + height - 30>=  targetY && y + height - 30< (targetY + item.getHeight())) )
//
                    (x >= targetX && x < (targetX + item.getWidth())) &&
                    (y >=  targetY && y < (targetY + item.getHeight()))
            ) {
                if (item instanceof BulletThroughWall) {
                    return false;
                }
                System.out.println("happen");
                CollisionEvent collisionEvent =
//                        new CollisionEvent(this, targetX, targetY);
                        new CollisionEvent(this,item);
                controller.getCollisionHandler().addCollisionEvent(collisionEvent);
                System.out.println("queue size :" + controller.getCollisionHandler().getCollisionEventsQueue().size());
                System.out.println("queue is empty :" + controller.getCollisionHandler().getCollisionEventsQueue().isEmpty());
//                System.out.println(controller.getCollisionHandler().getCollisionEventsQueue().size());
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public void onBeingAttacked() {

    }

    @Override
    public void onCollision() {
        delete();
    }

    private final int DIRECT_UP = 10001;
    private final int DIRECT_DOWN = 10002;
    private final int DIRECT_LEFT = 10003;
    private final int DIRECT_RIGHT = 10004;

}
