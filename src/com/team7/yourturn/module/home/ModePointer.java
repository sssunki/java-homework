package com.team7.yourturn.module.home;

import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;

import java.awt.event.KeyEvent;

public class ModePointer extends BaseViewModel {

    private final int POINT_TO_ONE_PLAYER = 1100;
    private final int POINT_TO_TWO_PLAYER = 1101;
    private final int DEFAULT_X = 400;
    private final int DEFAULT_Y = 400;
    private final int DEFAULT_WIDTH = 60;
    private final int DEFAULT_HEIGHT = 60;

    private int pointerState = POINT_TO_ONE_PLAYER;

    public ModePointer() {
        x = DEFAULT_X;
        y = DEFAULT_Y;
        this.itemComponent = new ItemComponent("test.jpg",DEFAULT_WIDTH,DEFAULT_HEIGHT);
        itemComponent.setLocation(x, y);
    }

    public int HandleEvent(int eventCode) {
        switch (eventCode) {

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_UP:
                return changePointer(eventCode);
            case KeyEvent.VK_ENTER:
                return PAGE_END;
            default:
                return NO_MEANING_EVENT;

        }
    }

    private int changePointer(int eventCode){
        int moveDistance = 120;

        switch (eventCode) {

            case KeyEvent.VK_DOWN:
                if (pointerState == POINT_TO_ONE_PLAYER){
                    pointerState = POINT_TO_TWO_PLAYER;
                    y += moveDistance;
                } else {
                    pointerState = POINT_TO_ONE_PLAYER;
                    y -= moveDistance;
                }
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;

            case KeyEvent.VK_UP:
                if (pointerState == POINT_TO_TWO_PLAYER){
                    pointerState = POINT_TO_ONE_PLAYER;
                    y -= moveDistance;
                } else {
                    pointerState = POINT_TO_TWO_PLAYER;
                    y += moveDistance;
                }
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;

            default:
                return CASE_WONT_HAPPEN;
        }
    }

    public int getPointerState() {
        return pointerState;
    }
}
