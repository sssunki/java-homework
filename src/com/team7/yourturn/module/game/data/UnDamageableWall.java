package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.module.base.BaseView;
import com.team7.yourturn.module.base.ItemComponent;

public class UnDamageableWall extends BaseView {

    public UnDamageableWall(String filename, int x, int y) {
        this.x = x;
        this.y = y;
        itemComponent = new ItemComponent(filename, width, height);
    }

}
