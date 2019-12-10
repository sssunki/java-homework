package com.team7.yourturn.module.checkpoint;

import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;

import java.awt.event.KeyEvent;

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
        return 0;
    }

    public int getPointerState() {
        return pointerState;
    }
}
