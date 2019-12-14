package com.team7.yourturn.module.checkpoint;

import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;
import com.team7.yourturn.utils.Bundle;

import java.awt.event.KeyEvent;
import static com.team7.yourturn.utils.EventCode.*;

public class CheckpointPointer extends BaseViewModel {

    private int POINT_TO_CHECKPOINT_ONE   = 2101;
    private int POINT_TO_CHECKPOINT_TWO   = 2102;
    private int POINT_TO_CHECKPOINT_THREE = 2103;

    private CheckpointPointer map;
    private int flag = 0;



    private int pointerState = POINT_TO_CHECKPOINT_ONE;
    String mapType;


    public CheckpointPointer() {
        x = 300;
        y = 600;
        this.itemComponent = new ItemComponent("checkChoose.jpg",60,60);
        itemComponent.setLocation(x, y);
    }

    public CheckpointPointer(ItemComponent itemComponent){
        x = 400;
        y = 300;
        this.itemComponent = itemComponent;
        itemComponent.setLocation(x, y);
    }


    public int HandleEvent(int eventCode) {
        switch (eventCode) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                return changePointer(eventCode);
            case KeyEvent.VK_ENTER:
                return PAGE_END;
            default:
                return NO_MEANING_EVENT;
        }
    }

    protected void changeMap(int pointerState){

        switch (pointerState){
            case 300 :
                mapType ="map1.jpg";
                break;
            case 445:
                mapType = "map2.jpg";
                break;
            default:
                mapType ="map3.jpg";
        }
        System.out.println(pointerState);

        if (flag > 0) {
            gameWindow.remove(map.itemComponent);
        }

        ItemComponent itemComponent= new ItemComponent(mapType);
        map=new CheckpointPointer(itemComponent);
        map.setX(300);
        map.setY(100);
        map.setWidth(300);
        map.setHeight(300);
        flag++;
        map.draw();
//        gameWindow.add(itemComponent);
//        gameWindow.setVisible(true);

    }

    public int changePointer(int eventCode) {
        // TODO: 与 ModePointer 里面的 changePointer 一样，改变关卡选择指针状态，更改绘图，返回 EVENT_HANDLE_SUCCESS 消息
        int moveDistance = 145;

        switch (eventCode) {
            case KeyEvent.VK_LEFT:
                if (pointerState == POINT_TO_CHECKPOINT_ONE){
                    pointerState = POINT_TO_CHECKPOINT_THREE;
                    x += moveDistance*2;
                } else if (pointerState == POINT_TO_CHECKPOINT_TWO){
                    pointerState = POINT_TO_CHECKPOINT_ONE;
                    x -= moveDistance;
                }
                else if (pointerState == POINT_TO_CHECKPOINT_THREE){
                    pointerState = POINT_TO_CHECKPOINT_TWO;
                    x -= moveDistance;
                }
                locationUpdate();
                changeMap(x);
                return EVENT_HANDLE_SUCCEED;

            case KeyEvent.VK_RIGHT:
                if (pointerState == POINT_TO_CHECKPOINT_ONE){
                    pointerState = POINT_TO_CHECKPOINT_TWO;
                    x += moveDistance;
                } else if (pointerState == POINT_TO_CHECKPOINT_TWO){
                    pointerState = POINT_TO_CHECKPOINT_THREE;
                    x += moveDistance;
                }
                else if (pointerState == POINT_TO_CHECKPOINT_THREE){
                    pointerState = POINT_TO_CHECKPOINT_ONE;
                    x -= moveDistance*2;
                }

                locationUpdate();
                changeMap(x);
                return EVENT_HANDLE_SUCCEED;
            default:
                return CASE_WONT_HAPPEN;
        }

    }

    @Override
    public void onCollision() {

    }

    public int getPointerState() {
        return pointerState;
    }

}