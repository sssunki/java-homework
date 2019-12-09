package com.team7.yourturn.module.base;

public abstract class BaseViewModel extends EventHandler{

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

    protected void locationUpdate() {
        itemComponent.setLocation(x,y);
    }

    protected void directUpdate() {

    }
}
