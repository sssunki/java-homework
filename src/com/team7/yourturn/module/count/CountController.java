package com.team7.yourturn.module.count;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.utils.Bundle;

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
        countPointer.draw();
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
        //gameWindow.setController(new CountController(bundle));
    }
}
