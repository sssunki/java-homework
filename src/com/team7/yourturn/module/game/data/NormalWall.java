package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.data.base.Item;

public class NormalWall extends Item implements Damageable {

    private int flag = 0;
    private int[][] mapMessage;
    Bullet bullet;

    public NormalWall(int x,int y,int width,int height,int flag){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }



    @Override
    public void onBeingAttacked() {
        int x=bullet.getX();
        int y=bullet.getY();
        if (mapMessage[x][y] == 1){
            mapMessage[x][y] = 0;
            //销毁墙
        }


    }
}
