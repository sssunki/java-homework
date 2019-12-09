package com.team7.yourturn.module.base;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class BaseController {

    protected Queue<Integer> eventQueue;
    protected GameWindow gameWindow = GameWindow.gameWindow;
    protected static final int PAGE_END = 1001;
    protected static final int NO_MEANING_EVENT = 1000;


    {
        eventQueue = new LinkedBlockingQueue<>();
    }

    public void addEvent(int eventCode) {
        eventQueue.offer(eventCode);
    }

    public abstract void start();

    protected abstract void initView();
    protected abstract int handleEvent(int eventCode);
    protected abstract void gotoNextPage();

}
