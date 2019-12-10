package com.team7.yourturn.module.base;

public class BaseView extends EventHandler{

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

    private void initLocation() {
        itemComponent.setLocation(x, y);
    }

}
