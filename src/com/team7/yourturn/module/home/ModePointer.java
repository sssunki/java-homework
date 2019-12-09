package com.team7.yourturn.module.home;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;

import javax.print.DocFlavor;
import java.awt.event.KeyEvent;

public class ModePointer extends BaseViewModel {

    private int POINT_TO_ONE_PLAYER = 1100;
    private int POINT_TO_TWO_PLAYER = 1101;

    private int pointerState = POINT_TO_ONE_PLAYER;

    public ModePointer() {
        x = 400;
        y = 400;
        this.itemComponent = new ItemComponent("test.jpg",60,60);
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
        switch (eventCode) {

            case KeyEvent.VK_DOWN:
                if (pointerState == POINT_TO_ONE_PLAYER){
                    pointerState = POINT_TO_TWO_PLAYER;
                    y += 120;
                } else {
                    pointerState = POINT_TO_ONE_PLAYER;
                    y -= 120;
                }
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;

            case KeyEvent.VK_UP:
                if (pointerState == POINT_TO_TWO_PLAYER){
                    pointerState = POINT_TO_ONE_PLAYER;
                    y -= 120;
                } else {
                    pointerState = POINT_TO_TWO_PLAYER;
                    y += 120;
                }
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;

            default:
                return CASE_WONT_HAPPEN;
        }
    }
}
