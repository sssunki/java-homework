package com.team7.yourturn.module.base;

public class BaseView extends EventHandler{

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected ItemComponent itemComponent;
    protected GameWindow gameWindow = GameWindow.getInstance();

    public void draw() {
        gameWindow.addComponent(itemComponent);
        gameWindow.setVisible(true);
    }

}
