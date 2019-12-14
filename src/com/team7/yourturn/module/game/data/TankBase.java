package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Damageable;
import com.team7.yourturn.module.base.BaseView;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;

import javax.swing.*;
import java.awt.*;

import static com.team7.yourturn.utils.EventCode.GAME_OVER;

public class TankBase extends BaseView {
    GameController gameController;
    public TankBase(String filename, int x, int y, GameController gameController) {
        this.x = x;
        this.y = y;
        itemComponent = new ItemComponent(filename, width, height);
        this.gameController = gameController;
    }

    @Override
    public void onCollision() {
        //game over
        Image image = new ImageIcon("src/image/explode1.jpg").getImage();
        itemComponent.setImage(image);
        itemComponent.repaint();
        gameController.addEvent(GAME_OVER);
    }

}
