package com.team7.yourturn.module.base;

import com.team7.yourturn.module.game.data.Player;

public abstract class BaseViewModel extends BaseView{


    protected void locationUpdate() {
        itemComponent.setLocation(x,y);
    }

    protected void directUpdateL(Player player) {
            int thisDirection=player.getDirection();
            //UP
            if(thisDirection==10001)
                itemComponent.setImage(itemComponent.rotateImageLeft90(itemComponent));
            //DOWN
            if(thisDirection==10002)
                itemComponent.setImage(itemComponent.rotateImageRight90(itemComponent));
            //RIGHT
            if (thisDirection==10004)
                itemComponent.setImage(itemComponent.rotateImage180(itemComponent));

    }
    protected void directUpdateR(Player player) {

        int thisDirection=player.getDirection();
        //UP
        if(thisDirection==10001)
            itemComponent.setImage(itemComponent.rotateImageRight90(itemComponent));
        //DOWN
        if(thisDirection==10002)
            itemComponent.setImage(itemComponent.rotateImageLeft90(itemComponent));
        //LEFT
        if (thisDirection==10003)
            itemComponent.setImage(itemComponent.rotateImage180(itemComponent));

    }
    protected void directUpdateU(Player player) {
        int thisDirection=player.getDirection();
        //LEFT
        if(thisDirection==10003)
            itemComponent.setImage(itemComponent.rotateImageRight90(itemComponent));
        //DOWN
        if(thisDirection==10002)
            itemComponent.setImage(itemComponent.rotateImage180(itemComponent));
        //RIGHT
        if (thisDirection==10004)
            itemComponent.setImage(itemComponent.rotateImageLeft90(itemComponent));

    }
    protected void directUpdateD(Player player) {
        int thisDirection=player.getDirection();
        //UP
        if(thisDirection==10001)
            itemComponent.setImage(itemComponent.rotateImage180(itemComponent));
        //LEFT
        if(thisDirection==10003)
            itemComponent.setImage(itemComponent.rotateImageLeft90(itemComponent));
        //RIGHT
        if (thisDirection==10004)
            itemComponent.setImage(itemComponent.rotateImageRight90(itemComponent));

    }
}
