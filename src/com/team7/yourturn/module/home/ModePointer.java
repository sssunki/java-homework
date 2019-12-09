package com.team7.yourturn.module.home;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;

import java.awt.event.KeyEvent;

public class ModePointer extends BaseViewModel {

    public ModePointer() {
        this.itemComponent = new ItemComponent("test.jpg",100,100);
    }

    public int HandleEvent(int eventCode) {
        switch (eventCode) {
            case KeyEvent.VK_DOWN:
                y += 50;
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;
            case KeyEvent.VK_UP:
                y -= 50;
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;
            case KeyEvent.VK_ENTER:
                return PAGE_END;
            default:
                return NO_MEANING_EVENT;
        }
    }
}
