package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.module.base.BaseView;
import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.GameWindow;
import com.team7.yourturn.module.base.ItemComponent;

public class NormalWall extends BaseViewModel {
    private int hp;
    public NormalWall(String filename, int x, int y) {
        this.x = x;
        this.y = y;
        itemComponent = new ItemComponent(filename, width, height);
        hp = 100;
    }


    public void onCollision() {
        hp = hp -10;
        if(hp == 0){
            delete();
        }

    }

    public void delete(){
        GameWindow gameWindow = GameWindow.getInstance();
        gameWindow.remove(itemComponent);
    }

}
