package com.team7.yourturn.module.game;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.BaseListener;

import java.awt.event.KeyEvent;

public class PlayerActionListener extends BaseListener {

    public PlayerActionListener(BaseController controller) {
        super(controller);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_SPACE:
                controller.addEvent(keyEvent.getKeyCode());
                break;
            default:
                break;
        }
    }

}
