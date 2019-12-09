package com.team7.yourturn.module.home;

import com.team7.yourturn.module.base.BaseController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class ModeSelectListener implements KeyListener {

    private BaseController parentController;

    public ModeSelectListener(BaseController controller) {
        parentController = controller;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                parentController.addEvent(KeyEvent.VK_DOWN);
                System.out.println("get Message");
                break;
            case KeyEvent.VK_UP:
                parentController.addEvent(KeyEvent.VK_UP);
                break;
            case KeyEvent.VK_ENTER:
                parentController.addEvent(KeyEvent.VK_ENTER);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}
