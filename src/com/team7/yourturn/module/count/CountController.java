package com.team7.yourturn.module.count;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.checkpoint.CheckpointPointer;
import com.team7.yourturn.module.home.HomeController;
import com.team7.yourturn.utils.Bundle;

import javax.swing.*;
import java.awt.*;

public class CountController extends BaseController {

    private CountPointer countPointer;
    private int numOfChoose;

    public CountController(){
        countPointer=new CountPointer();
    }

    public CountController(Bundle bundle){
        super(bundle);
        countPointer = new CountPointer();
        numOfChoose=bundle.getInt("choose");
    }

    @Override
    protected void initEvent() {
        gameWindow.addKeyListener(new CountSelectedListener(this));
    }

    @Override
    protected void initView() {
        //countPointer.draw();

        int score = 1;

        JLabel jLabel=new JLabel(String.valueOf(String.valueOf(score)));
        jLabel.setBackground(Color.RED);
        jLabel.setBounds(300,50,200,100);
        jLabel.setVisible(true);
        gameWindow.add(jLabel);

        CountPointer map;
        ItemComponent itemComponent= new ItemComponent("gameover4.jpg");
        itemComponent.setHeight(600);
        itemComponent.setWidth(900);
        map=new CountPointer(itemComponent);
        map.setX(100);
        map.setY(100);
        map.setWidth(800);
        map.setHeight(800);
        map.draw();

//        CountPointer map1;
//        ItemComponent itemComponent1= new ItemComponent("gameover4.jpg");
//        itemComponent1.setHeight(200);
//        itemComponent1.setWidth(900);
//        map1=new CountPointer(itemComponent1);
//        map1.setX(100);
//        map1.setY(400);
//        //map1.setWidth(800);
//        //map1.setHeight(600);
//        map1.draw();
    }

    @Override
    protected int handleEvent(int eventCode) {
        return countPointer.HandleEvent(eventCode);
        //return gameWindow.addKeyListener(new CountSelectedListener(this));
    }

    @Override
    protected void gotoNextPage() {
        Bundle bundle = new Bundle();
        bundle.addInt("choosePoint",countPointer.getPointerState());
        gameWindow.setController(new HomeController());

    }
}
