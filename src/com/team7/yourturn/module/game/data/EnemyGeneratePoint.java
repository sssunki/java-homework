package com.team7.yourturn.module.game.data;

import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.BaseView;
import com.team7.yourturn.module.game.GameController;
import com.team7.yourturn.module.game.collision.CollisionEvent;
import com.team7.yourturn.utils.EventCode;

import static com.team7.yourturn.utils.EventCode.GENERATE_AN_ENEMY;

public class EnemyGeneratePoint extends BaseView {

    public boolean readyToGenerateEnemy;

    private GameController controller;

    public EnemyGeneratePoint(int x, int y, GameController controller) {
        this.x = x;
        this.y = y;
        this.controller = controller;
        readyToGenerateEnemy = true;
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int enemyLeft = GameController.getEnemyLeft();
                    if (enemyLeft != 0) {
                        int enemyExist = 3 - enemyLeft;
                        System.out.println(enemyExist);
                        controller.addEvent(GENERATE_AN_ENEMY);
                        GameController.setEnemyLeft(enemyLeft - 1);
                    }
                }
            }
        }).start();
    }

    public boolean hasthing(){
        boolean result = false;
        for (Item item :controller.getItems()) {
            int targetX = item.getX();
            int targetY = item.getY();

            if  ( (x >= targetX && x < (targetX + item.getWidth())) &&
                    (targetY == 0) ) {
                result = true;
            }
        }
        return result;
    }

}
