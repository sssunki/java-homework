package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.GameWindow;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

import static com.team7.yourturn.utils.EventCode.*;

public class Player extends BaseViewModel implements Movable , Damageable {


    private int direction;
    private GameController controller;
    private int hp;

    public Player(String filename, int x, int y, GameController controller) {
        this.x = x;
        this.y = y;
        this.direction = DIRECT_UP;
        this.controller = controller;
        itemComponent = new ItemComponent(filename, width, height);
    }

    public int handleEvent(int eventCode) {
        switch (eventCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                return changeLocationAndDirection(eventCode);
            case KeyEvent.VK_PAGE_UP:
                return ITEM_ATTACK;
            case KeyEvent.VK_SPACE:

                return GAME_STOP;
            default:
                return CASE_WONT_HAPPEN;
        }
    }

    private int changeLocationAndDirection(int eventCode) {
        int yLast = y;
        int xLast = x;
//        System.out.println(x + " " + y);
        switch (eventCode) {

            case KeyEvent.VK_UP:
                y -= 30;
                if (collisionDetection()){
                    y = yLast;
                } else {
                    directUpdateU(this.direction);
                    locationUpdate();
                    direction = DIRECT_UP;
                }
                return EVENT_HANDLE_SUCCEED;

            case KeyEvent.VK_DOWN:
                y += 30;
                if (collisionDetection()) {
                    y = yLast;
                } else {
                    directUpdateD(this.direction);
                    locationUpdate();
                    direction = DIRECT_DOWN;
                }
                return EVENT_HANDLE_SUCCEED;

            case KeyEvent.VK_RIGHT:
                x += 30;
                if (collisionDetection()) {
                    x = xLast;
                } else {
                    directUpdateR(this.direction);
                    locationUpdate();
                    direction = DIRECT_RIGHT;
                }
                return EVENT_HANDLE_SUCCEED;

            case KeyEvent.VK_LEFT:
                x -= 30;
                if (collisionDetection()) {
                    x = xLast;
                } else {
                    directUpdateL(this.direction);
                    locationUpdate();
                    direction = DIRECT_LEFT;
                }
                return EVENT_HANDLE_SUCCEED;
        }
        return CASE_WONT_HAPPEN;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public boolean collisionDetection() {
        boolean result = false;

        for (Item item : controller.getCheckpointMap().getBarriers()) {

            if (item instanceof Player) {
                continue;
            }

            int targetX = item.getX();
            int targetY = item.getY();

            if (
                    ((x >= targetX && x< (targetX + item.getWidth())) && (y >=  targetY && y < (targetY + item.getHeight())) )
                            || ((x + width >= targetX && x + width < (targetX + item.getWidth())) && (y >=  targetY && y < (targetY + item.getHeight())) )
                            || ((x >= targetX && x < (targetX + item.getWidth())) && (y + height - 30>=  targetY && y + height - 30< (targetY + item.getHeight())) )
                            || ((x + width >= targetX && x + width < (targetX + item.getWidth())) && (y + height - 30>=  targetY && y + height - 30< (targetY + item.getHeight())) )

            ) {
                result = true;
                break;
            }
        }

        return result;
    }


    @Override
    public void onBeingAttacked() {

        hp = hp-1;
        if(hp == 0){
            controller.addEvent(GAME_OVER);
        }
    }

    @Override
    public void onCollision() {
        onBeingAttacked();
    }

    private final int DIRECT_UP = 10001;
    private final int DIRECT_DOWN = 10002;
    private final int DIRECT_LEFT = 10003;
    private final int DIRECT_RIGHT = 10004;
}
