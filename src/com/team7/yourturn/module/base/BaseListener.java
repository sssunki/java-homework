package com.team7.yourturn.module.base;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class BaseListener implements KeyListener {

    protected BaseController controller;

    public BaseListener(BaseController controller) {
        this.controller = controller;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
