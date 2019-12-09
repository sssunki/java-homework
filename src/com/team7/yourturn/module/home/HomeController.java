package com.team7.yourturn.module.home;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.utils.Bundle;

import java.awt.event.KeyEvent;

public class HomeController extends BaseController {

    private ModePointer modePointer;

    public HomeController() {
        modePointer = new ModePointer();

    }

    @Override
    public void start() {
        initView();
        initEvent();
        while (true) {
            int eventCode;
            if (!eventQueue.isEmpty()) {

                eventCode = eventQueue.poll();
                System.out.println(eventCode); // debug
                if (handleEvent(eventCode) == PAGE_END) {
                    break;
                }

            }
        }
        gotoNextPage();

    }

    @Override
    protected void initEvent() {
        gameWindow.addKeyListener(new ModeSelectListener(this));
    }

    @Override
    protected void initView() {
        modePointer.draw();
    }

    @Override
    protected int handleEvent(int eventCode) {
        return modePointer.HandleEvent(eventCode);
    }

    @Override
    protected void gotoNextPage() {
        Bundle bundle = new Bundle();

    }
}
