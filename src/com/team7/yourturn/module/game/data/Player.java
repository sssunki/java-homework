package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;

import java.awt.event.KeyEvent;

import static com.team7.yourturn.utils.EventCode.*;

public class Player extends BaseViewModel implements Movable {

    public Player(String filename, int x, int y) {
        this.x = x;
        this.y = y;
        itemComponent = new ItemComponent(filename, width, height);
    }

    public int handleEvent(int eventCode) {
        switch (eventCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                return changeLocation(eventCode);
            case KeyEvent.VK_PAGE_UP:
                return ITEM_ATTACK;
            case KeyEvent.VK_SPACE:
                return GAME_STOP;
            default:
                return CASE_WONT_HAPPEN;
        }
    }

    private int changeLocation(int eventCode) {
        switch (eventCode) {
            case KeyEvent.VK_UP:
                y -= 30;
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;
            case KeyEvent.VK_DOWN:
                y += 30;
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;
            case KeyEvent.VK_RIGHT:
                x += 30;
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;
            case KeyEvent.VK_LEFT:
                x -= 30;
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;
        }
        return CASE_WONT_HAPPEN;
    }

    @Override
    public boolean collisionDetection() {

        return false;
    }
}
