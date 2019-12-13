package com.team7.yourturn.module.game.data;

import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.GameWindow;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;

public class NormalWall extends BaseViewModel {
    private int hp;
    private GameController gameController;

    public NormalWall(String filename, int x, int y, GameController gameController) {
        this.x = x;
        this.y = y;
        itemComponent = new ItemComponent(filename, width, height);
        hp = 10;
        this.gameController = gameController;
    }


//    @Override
    public void onCollision() {
        hp = hp - 10;
        System.out.println(hp);
        if(hp == 0){
            delete();
        }
    }

    public void delete(){
        GameWindow gameWindow = GameWindow.getInstance();
        gameWindow.remove(itemComponent);
        System.out.println(gameController == null);
        gameController.deleteItem(this);
//        System.out.println(gameController.getCheckpointMap().getBarriers().contains(this));
    }

}
