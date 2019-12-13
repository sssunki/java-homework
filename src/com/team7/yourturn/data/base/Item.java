package com.team7.yourturn.data.base;

public abstract class Item implements Collidable{

    protected final int DEFAULT_WIDTH = 60;
    protected final int DEFAULT_HEIGHT = 60;


    protected int x;
    protected int y;
    protected int width = DEFAULT_WIDTH;
    protected int height = DEFAULT_HEIGHT;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

//    @Override
//    public void onCollision() {
//
//    }
}
