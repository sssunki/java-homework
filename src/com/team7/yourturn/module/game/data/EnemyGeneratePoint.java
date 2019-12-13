package com.team7.yourturn.module.game.data;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.BaseView;
import com.team7.yourturn.module.game.GameController;
import com.team7.yourturn.utils.EventCode;

import static com.team7.yourturn.module.game.GameController.enemyExist;
import static com.team7.yourturn.module.game.GameController.enemyLeft;
import static com.team7.yourturn.utils.EventCode.GENERATE_AN_ENEMY;

public class EnemyGeneratePoint extends BaseView {

    @Override
    public void onCollision() {

    }

    public boolean readyToGenerateEnemy;

    private BaseController controller;

    public EnemyGeneratePoint(int x, int y, BaseController controller) {
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

                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (enemyLeft != 0 && enemyExist != 3) {
                        controller.addEvent(GENERATE_AN_ENEMY);
                        enemyExist++;
                        enemyLeft--;
                        System.out.println("enemyExist :" + enemyExist + "\nenemyLeft :" + enemyLeft);
                    }
                }
            }
        }).start();
    }


}
