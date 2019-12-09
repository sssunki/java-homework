package com.team7.yourturn.module.home;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.utils.Bundle;

import java.awt.event.KeyEvent;

public class HomeController extends BaseController {


    @Override
    public void start() {
        initView();
        while (true) {
            int eventCode;
            if (!eventQueue.isEmpty()) {

                eventCode = eventQueue.poll();
                if (handleEvent(eventCode) == PAGE_END) {
                    break;
                }

            }
        }
        gotoNextPage();

    }


    @Override
    protected void initView() {

    }

    @Override
    protected int handleEvent(int eventCode) {

        switch (eventCode) {
            case KeyEvent.VK_UP:

                break;
            case KeyEvent.VK_DOWN:

                break;
            case KeyEvent.VK_ENTER:

                return PAGE_END;
        }

        return NO_MEANING_EVENT;
    }

    @Override
    protected void gotoNextPage() {
        Bundle bundle = new Bundle();

    }
}
