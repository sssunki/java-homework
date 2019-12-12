package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;

import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

import static com.team7.yourturn.utils.EventCode.*;

public class Player extends BaseViewModel implements Movable {

    private int direction;

    public Player(String filename, int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = DIRECT_UP;
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
        switch (eventCode) {
            case KeyEvent.VK_UP:
                y -= 30;
                directUpdateU(this);
                locationUpdate();
                direction = DIRECT_UP;
                return EVENT_HANDLE_SUCCEED;
            case KeyEvent.VK_DOWN:
                y += 30;
                directUpdateD(this);
                locationUpdate();
                direction = DIRECT_DOWN;
                return EVENT_HANDLE_SUCCEED;
            case KeyEvent.VK_RIGHT:
                x += 30;
                directUpdateR(this);
                locationUpdate();
                direction = DIRECT_RIGHT;
                return EVENT_HANDLE_SUCCEED;
            case KeyEvent.VK_LEFT:
                x -= 30;
                directUpdateL(this);
                locationUpdate();
                direction = DIRECT_LEFT;
                return EVENT_HANDLE_SUCCEED;
        }
        return CASE_WONT_HAPPEN;
    }

    public int getDirection() {
        return direction;
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
