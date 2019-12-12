package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Movable;
import com.team7.yourturn.module.base.BaseViewModel;

public class Enemy extends BaseViewModel implements Movable {

    private EnemyGeneratePoint parentGeneratePoint;
    private int enemyId;

    public Enemy(int x, int y, EnemyGeneratePoint parentGeneratePoint) {
        this.x = x;
        this.y = y;
        this.parentGeneratePoint = parentGeneratePoint;
    }

    public void start() {

    }

    @Override
    public boolean collisionDetection() {
        return false;
    }
}
