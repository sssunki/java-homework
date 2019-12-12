package com.team7.yourturn.module.base;

import com.team7.yourturn.data.base.Item;

public class BaseView extends Item {

    protected final int DEFAULT_WIDTH = 60;
    protected final int DEFAULT_HEIGHT = 60;

    protected int x;
    protected int y;
    protected int width = DEFAULT_WIDTH;
    protected int height = DEFAULT_HEIGHT;
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
    }

}
