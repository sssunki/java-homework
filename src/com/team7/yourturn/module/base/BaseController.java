package com.team7.yourturn.module.base;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class BaseController extends EventHandler{

    protected Queue<Integer> eventQueue;
    protected GameWindow gameWindow = GameWindow.gameWindow;


    {
        eventQueue = new LinkedBlockingQueue<>();
    }

    public void addEvent(int eventCode) {
        eventQueue.offer(eventCode);
    }

    public abstract void start();

    protected abstract void initEvent();
    protected abstract void initView();
    protected abstract int handleEvent(int eventCode);
    protected abstract void gotoNextPage();

}
