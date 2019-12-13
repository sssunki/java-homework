package com.team7.yourturn.data.map;

import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.module.game.data.NormalWall;

import java.util.LinkedList;
import java.util.List;

public class CheckpointOne extends CheckpointMap{

    {
        barriers = new LinkedList<>();
        barriers.add(new NormalWall("test.jpg",100,400));
        barriers.add(new NormalWall("test.jpg",200,400));
        barriers.add(new NormalWall("test.jpg",300,400));
        barriers.add(new NormalWall("test.jpg",400,400));
        barriers.add(new NormalWall("test.jpg",500,400));
        barriers.add(new NormalWall("test.jpg",600,400));
        barriers.add(new NormalWall("test.jpg",700,400));
        barriers.add(new NormalWall("test.jpg",800,400));
    }

}
