package com.team7.yourturn.module.checkpoint;

import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;

import java.awt.event.KeyEvent;
import static com.team7.yourturn.utils.EventCode.*;

public class CheckpointPointer extends BaseViewModel {

    private int POINT_TO_CHECKPOINT_ONE   = 2101;
    private int POINT_TO_CHECKPOINT_TWO   = 2102;
    private int POINT_TO_CHECKPOINT_THREE = 2103;
    private int POINT_TO_CHECKPOINT_FOUR  = 2104;
    private int POINT_TO_CHECKPOINT_FIVE  = 2105;

    private int pointerState = POINT_TO_CHECKPOINT_ONE;


    public CheckpointPointer() {
        x = 300;
        y = 700;
        this.itemComponent = new ItemComponent("test.jpg",60,60);
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


    public int changePointer(int eventCode) {
        // TODO: 与 ModePointer 里面的 changePointer 一样，改变关卡选择指针状态，更改绘图，返回 EVENT_HANDLE_SUCCESS 消息
        int moveDistance = 100;

        switch (eventCode) {
            case KeyEvent.VK_LEFT:
                if (pointerState == POINT_TO_CHECKPOINT_ONE){
                    pointerState = POINT_TO_CHECKPOINT_FIVE;
                    x += moveDistance*4;
                } else if (pointerState == POINT_TO_CHECKPOINT_TWO){
                    pointerState = POINT_TO_CHECKPOINT_ONE;
                    x -= moveDistance;
                }
                else if (pointerState == POINT_TO_CHECKPOINT_THREE){
                    pointerState = POINT_TO_CHECKPOINT_TWO;
                    x -= moveDistance;
                }
                else if (pointerState == POINT_TO_CHECKPOINT_FOUR){
                    pointerState = POINT_TO_CHECKPOINT_THREE;
                    x -= moveDistance;
                }
                else if (pointerState == POINT_TO_CHECKPOINT_FIVE){
                    pointerState = POINT_TO_CHECKPOINT_FOUR;
                    x -= moveDistance;
                }
                locationUpdate();
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
                    pointerState = POINT_TO_CHECKPOINT_FOUR;
                    x += moveDistance;
                }
                else if (pointerState == POINT_TO_CHECKPOINT_FOUR){
                    pointerState = POINT_TO_CHECKPOINT_FIVE;
                    x += moveDistance;
                }
                else if (pointerState == POINT_TO_CHECKPOINT_FIVE){
                    pointerState = POINT_TO_CHECKPOINT_ONE;
                    x -= moveDistance*4;
                }
                locationUpdate();
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