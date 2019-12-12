package com.team7.yourturn.data.map;

import com.team7.yourturn.data.base.Item;

import java.util.List;

public abstract class CheckpointMap {
    protected List<Item> barriers;

    public List<Item> getBarriers() {
        return barriers;
    }
}
