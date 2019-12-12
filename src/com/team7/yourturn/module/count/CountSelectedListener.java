package com.team7.yourturn.module.count;

import com.team7.yourturn.module.base.BaseController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CountSelectedListener implements KeyListener {

    private BaseController parentController;

    public CountSelectedListener(BaseController controller){
        parentController = controller;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                parentController.addEvent(KeyEvent.VK_DOWN);
                System.out.println("get count Message");
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
    public void keyReleased(KeyEvent e) {

    }
}
