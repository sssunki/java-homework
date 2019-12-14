package com.team7.yourturn.module.checkpoint;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.GameWindow;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.module.game.GameController;
import com.team7.yourturn.utils.Bundle;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class CheckpointController extends BaseController {

    private int numOfPlayer;
    private int checkpointSelected;
    private CheckpointPointer checkpointPointer;



    public CheckpointController() {

    }

    public CheckpointController(Bundle bundle) {
        super(bundle);
        checkpointPointer = new CheckpointPointer();
        numOfPlayer = bundle.getInt("player");
    }

    @Override
    protected void initView() {
        checkpointPointer.draw();
        addEvent(KeyEvent.VK_RIGHT);
        checkpointPointer.HandleEvent(KeyEvent.VK_LEFT);

        //CheckpointPointer
        CheckpointPointer map;
        ItemComponent itemComponent= new ItemComponent("check1.jpg");
        itemComponent.setHeight(100);
        map=new CheckpointPointer(itemComponent);
        map.setX(300);
        map.setY(0);
        map.setWidth(300);
        map.setHeight(100);
        map.draw();

        CheckpointPointer map1;
        ItemComponent itemComponent1= new ItemComponent("check3.jpg");
        itemComponent1.setHeight(150);
        map1=new CheckpointPointer(itemComponent1);
        map1.setX(260);
        map1.setY(430);
        map1.setWidth(300);
        map1.setHeight(200);
        map1.draw();

    }

    @Override
    protected void initEvent() {
        gameWindow.addKeyListener(new CheckpointSelectListener(this));
    }

    @Override
    protected int handleEvent(int eventCode) {

        return checkpointPointer.HandleEvent(eventCode);
    }

    @Override
    protected void gotoNextPage() {
        Bundle bundle = new Bundle();
        bundle.addInt("player", numOfPlayer);//玩家数量
        bundle.addInt("checkpoint",checkpointPointer.getPointerState());//关卡
        gameWindow.setController(new GameController(bundle));
    }
}
