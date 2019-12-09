package com.team7.yourturn.module.checkpoint;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.GameWindow;

public class CheckpointController extends BaseController {


    public CheckpointController() {

    }

    @Override
    public void start() {
        initView();
        while (true) {
            if (!eventQueue.isEmpty()) {
                int eventCode = eventQueue.poll();
            }
        }
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected int handleEvent(int eventCode) {
        return 0;
    }

    @Override
    protected void gotoNextPage() {

    }
}
