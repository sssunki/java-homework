package com.team7.yourturn.data.map;

import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.module.game.data.NormalWall;

import java.util.LinkedList;
import java.util.List;

public class CheckpointOne extends CheckpointMap{

    {
        barriers = new LinkedList<>();
        barriers.add(new NormalWall("test.jpg",800,400));
    }

}
