package com.team7.yourturn.module.base;

import com.team7.yourturn.module.count.CountController;
import com.team7.yourturn.module.game.GameController;
import com.team7.yourturn.module.home.HomeController;
import com.team7.yourturn.test.ItemComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
public class GameWindow extends JFrame {

    public static GameWindow gameWindow;

    private BaseController controller;

    static {
        gameWindow = new GameWindow();
        gameWindow.setSize(1000,800);
        gameWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.BLACK);
        gameWindow.setVisible(true);
    }

    public static GameWindow getInstance() {
        return gameWindow;
    }

    public static void main(String[] args) {
        HomeController startController = new HomeController();
        gameWindow.setController(startController);
//        GameController gameController = new GameController();
//        gameWindow.setController(gameController);

//        CountController controller =new CountController();
//        gameWindow.setController(controller);

    }

    public void addComponent(JComponent ... jComponents) {
        for (JComponent jComponent : jComponents) {
            gameWindow.getContentPane().add(jComponent);
        }
    }

    public void setController(BaseController controller) {
        // TODO：清除旧页面贴图
        this.getContentPane().removeAll();
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
        this.controller = controller;
        controller.start();
    }


}
