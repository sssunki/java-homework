package com.team7.yourturn.module.checkpoint;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.BaseListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CheckpointSelectListener extends BaseListener {


    public CheckpointSelectListener(BaseController controller) {
        super(controller);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                controller.addEvent(KeyEvent.VK_LEFT);
                System.out.println("get check Message");
                break;
            case KeyEvent.VK_RIGHT:
                controller.addEvent(KeyEvent.VK_RIGHT);
                break;
            case KeyEvent.VK_ENTER:
                controller.addEvent(KeyEvent.VK_ENTER);
                break;

        }

    }

}

