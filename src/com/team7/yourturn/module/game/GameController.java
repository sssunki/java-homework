package com.team7.yourturn.module.game;

import com.team7.yourturn.data.map.CheckpointMap;
import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.game.data.Bullet;
import com.team7.yourturn.module.game.data.Enemy;
import com.team7.yourturn.module.game.data.EnemyGeneratePoint;
import com.team7.yourturn.module.game.data.Player;
import com.team7.yourturn.utils.Bundle;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.team7.yourturn.utils.EventCode.*;

public class GameController extends BaseController {


    private Bundle bundle;
    private int numOfPlayer;
    private int checkpoint;

    private CheckpointMap checkpointMap;
    private static int enemyLeft;
    private List<EnemyGeneratePoint> enemyGeneratePoints;

    private Player player;
    private List<Enemy> enemies;
    private int[][] mapMessage;

    public CheckpointMap getCheckpointMap() {
        return checkpointMap;
    }

    public GameController(Bundle bundle) {
        super(bundle);
    }

    public GameController(){

    }

    @Override
    protected void initEvent() {
        gameWindow.addKeyListener(new PlayerActionListener(this));
        for (EnemyGeneratePoint enemyGeneratePoint : enemyGeneratePoints) {
            enemyGeneratePoint.start();
        }
    }

    @Override
    protected void initView() {
        player = new Player("test.jpg",400,700);
        enemyGeneratePoints = new ArrayList<>();
        enemyGeneratePoints.add(new EnemyGeneratePoint(0, 0, this));
        enemyGeneratePoints.add(new EnemyGeneratePoint(300, 0, this));
        enemyGeneratePoints.add(new EnemyGeneratePoint(600, 0, this));
        player.draw();

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
                return player.handleEvent(eventCode);
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_SPACE:
                Bullet bullet = new Bullet(player.getDirection(),player.getX(),player.getY(), this);
                bullet.draw();
                bullet.move();
                return EVENT_HANDLE_SUCCEED;
            case GENERATE_AN_ENEMY:


        }
        return CASE_WONT_HAPPEN;
    }

    public static synchronized int getEnemyLeft() {
        return enemyLeft;
    }

    public static synchronized void setEnemyLeft(int e) {
        enemyLeft = e;
    }

    public synchronized boolean generateEnemy() {
        if (enemyLeft != 0) {
            addEvent(GENERATE_AN_ENEMY);
        }

        return false;
    }

    public synchronized void declineEnemyLeft() {
        enemyLeft--;
    }

    @Override
    protected void gotoNextPage() {

    }

    //private class
}
