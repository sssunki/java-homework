package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.module.base.BaseView;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;

public class UnDamageableWall extends BaseViewModel {

    private GameController controller;

    @Override
    public void onCollision() {

    }

    public UnDamageableWall(String filename, int x, int y, GameController controller) {
        this.x = x;
        this.y = y;
        itemComponent = new ItemComponent(filename, width, height);
        this.controller = controller;
    }

}
