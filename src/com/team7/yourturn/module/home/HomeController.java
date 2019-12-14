package com.team7.yourturn.module.home;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.checkpoint.CheckpointController;
import com.team7.yourturn.utils.Bundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.security.Key;



public class HomeController extends BaseController {


    private ModePointer modePointer;


    public HomeController() {
        modePointer = new ModePointer();
    }


    @Override
    protected void initEvent() {
        gameWindow.addKeyListener(new ModeSelectListener(this));
    }

    @Override
    protected void initView() {
        modePointer.draw();
        //modePointer.HandleEvent(MOVE_UP);

        // 设置背景
        JLabel jlpic = new JLabel();
        JPanel jPanel = new JPanel();
        ImageIcon icon = new ImageIcon("src/image/"+"splash.jpg");

        jlpic.setIcon(icon);
        jlpic.setSize(1000,800);
        jPanel.add(jlpic);
        jPanel.setSize(1000,800);

        gameWindow.add(jPanel);
        gameWindow.pack();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }

    @Override
    protected int handleEvent(int eventCode) {

        return modePointer.HandleEvent(eventCode);
    }

    @Override
    protected void gotoNextPage() {
        Bundle bundle = new Bundle();
        bundle.addInt("player",modePointer.getPointerState());
        gameWindow.setController(new CheckpointController(bundle));
    }
}
