package com.team7.yourturn.data.map;

import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.game.GameController;

import java.util.List;

public abstract class CheckpointMap {
    protected List<Item> barriers;
    protected GameController controller;

    public void setController(GameController gameController) {
        this.controller = gameController;
    }

    public abstract void mapInit();

    public List<Item> getBarriers() {
        return barriers;
    }
}
