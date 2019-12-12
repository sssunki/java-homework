package com.team7.yourturn.module.home;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.checkpoint.CheckpointController;
import com.team7.yourturn.utils.Bundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;

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

        // 设置背景
        JLabel lblBackground = new JLabel(); // 创建一个标签组件对
        URL resource = this.getClass().getResource("test.jpg"); // 获取背景图片路径
        ImageIcon icon = new ImageIcon(resource); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0,0, 1000,800); // 设置组件的显示位置及大小
        gameWindow.add(lblBackground); // 将组件添加到面板中



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
