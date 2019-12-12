package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;

public class Bullet extends BaseViewModel implements Movable {

    private int direction;
    private GameController controller;

    public Bullet(int direction, int x, int y, GameController controller) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.controller = controller;
        itemComponent = new ItemComponent("test.jpg", width, height);
    }

    public void move() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!collisionDetection()) {
                    try {
                        Thread.sleep(30);
                        x += 10;
                        locationUpdate();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public boolean collisionDetection() {
        boolean result;
           for (Item item : controller.getCheckpointMap().getBarriers()) {
            int targetX = item.getX();
            int targetY = item.getY();

//            if (x > targetX && x < (targetX + item.getWidth())) {
//                controller.addEvent();
//            }
        }


        return false;
    }

    private final int DIRECT_UP = 10001;
    private final int DIRECT_DOWN = 10002;
    private final int DIRECT_LEFT = 10003;
    private final int DIRECT_RIGHT = 10004;

}
