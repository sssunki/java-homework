package com.team7.yourturn.module.base;

import com.team7.yourturn.data.base.Item;

public abstract class BaseView extends Item {

    protected ItemComponent itemComponent;
    protected GameWindow gameWindow = GameWindow.getInstance();

    public void draw() {
        gameWindow.addComponent(itemComponent);
        gameWindow.setVisible(true);
        initLocation();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void initLocation() {
        itemComponent.setLocation(x, y);
//        gameWindow.setVisible(true);
    }

}
