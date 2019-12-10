package com.team7.yourturn.module.game;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.game.data.EnemyGeneratePoint;
import com.team7.yourturn.module.game.data.Player;
import com.team7.yourturn.utils.Bundle;
import com.team7.yourturn.utils.EventCode;

import java.awt.event.KeyEvent;

import static com.team7.yourturn.utils.EventCode.CASE_WONT_HAPPEN;

public class GameController extends BaseController {

    private Bundle bundle;
    private int numOfPlayer;
    private int checkpoint;
    private Player player;
    private EnemyGeneratePoint enemyGeneratePoint;

    public GameController(Bundle bundle) {
        super(bundle);
    }

    public GameController(){

    }

    @Override
    protected void initEvent() {
        gameWindow.addKeyListener(new PlayerActionListener(this));
    }

    @Override
    protected void initView() {
        player = new Player("test.jpg",400,700);
        enemyGeneratePoint = new EnemyGeneratePoint();
        player.draw();
    }

    private void initPlayer() {

    }

    private void initMap() {

    }

    private void initEnemy() {

    }

    @Override
    protected int handleEvent(int eventCode) {
        switch(eventCode){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_SPACE:
                return player.handleEvent(eventCode);

        }
        return CASE_WONT_HAPPEN;
    }



    @Override
    protected void gotoNextPage() {

    }
}
