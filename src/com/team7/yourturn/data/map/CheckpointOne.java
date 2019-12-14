package com.team7.yourturn.data.map;

import com.team7.yourturn.data.base.Item;
import com.team7.yourturn.module.game.data.NormalWall;
import com.team7.yourturn.module.game.data.TankBase;

import java.util.LinkedList;
import java.util.List;

public class CheckpointOne extends CheckpointMap{

    @Override
    public void mapInit() {

        barriers = new LinkedList<>();
        barriers.add(new NormalWall("normal.jpg",0,0,controller));
        barriers.add(new NormalWall("normal.jpg",60,0,controller));
        barriers.add(new NormalWall("normal.jpg",120,0,controller));
        barriers.add(new NormalWall("normal.jpg",180,0,controller));
        barriers.add(new NormalWall("normal.jpg",240,0,controller));
        barriers.add(new NormalWall("normal.jpg",300,0,controller));
        barriers.add(new NormalWall("normal.jpg",360,0,controller));
        barriers.add(new NormalWall("normal.jpg",420,0,controller));
        barriers.add(new NormalWall("normal.jpg",480,0,controller));
        barriers.add(new NormalWall("normal.jpg",540,0,controller));
        barriers.add(new NormalWall("normal.jpg",600,0,controller));
        barriers.add(new NormalWall("normal.jpg",660,0,controller));
        barriers.add(new NormalWall("normal.jpg",720,0,controller));
        barriers.add(new NormalWall("normal.jpg",780,0,controller));
        barriers.add(new NormalWall("normal.jpg",840,0,controller));
        barriers.add(new NormalWall("normal.jpg",900,0,controller));
        barriers.add(new NormalWall("normal.jpg",900,0,controller));
        barriers.add(new NormalWall("normal.jpg",0,60,controller));
        barriers.add(new NormalWall("normal.jpg",0,120,controller));
        barriers.add(new NormalWall("normal.jpg",0,180,controller));
        barriers.add(new NormalWall("normal.jpg",0,240,controller));
        barriers.add(new NormalWall("normal.jpg",0,300,controller));
        barriers.add(new NormalWall("normal.jpg",0,360,controller));
        barriers.add(new NormalWall("normal.jpg",60,360,controller));
        barriers.add(new NormalWall("normal.jpg",120,360,controller));
        barriers.add(new NormalWall("normal.jpg",180,360,controller));
        barriers.add(new NormalWall("normal.jpg",240,360,controller));
        barriers.add(new NormalWall("normal.jpg",300,360,controller));
        barriers.add(new NormalWall("normal.jpg",360,360,controller));
        barriers.add(new NormalWall("normal.jpg",420,360,controller));
        barriers.add(new NormalWall("normal.jpg",480,360,controller));
        barriers.add(new NormalWall("normal.jpg",540,360,controller));
        barriers.add(new NormalWall("normal.jpg",600,360,controller));
        barriers.add(new NormalWall("normal.jpg",660,360,controller));
        barriers.add(new NormalWall("normal.jpg",720,360,controller));
        barriers.add(new NormalWall("normal.jpg",780,360,controller));
        barriers.add(new NormalWall("normal.jpg",840,360,controller));
        barriers.add(new NormalWall("normal.jpg",900,360,controller));
        barriers.add(new NormalWall("normal.jpg",900,300,controller));
        barriers.add(new NormalWall("normal.jpg",900,240,controller));
        barriers.add(new NormalWall("normal.jpg",900,180,controller));
        barriers.add(new NormalWall("normal.jpg",900,120,controller));
        barriers.add(new NormalWall("normal.jpg",900,60,controller));
        barriers.add(new TankBase("flag.jpg",500,700,controller));
        barriers.add(new NormalWall("normal.jpg",500,640,controller));
        barriers.add(new NormalWall("normal.jpg",440,640,controller));
        barriers.add(new NormalWall("normal.jpg",440,700,controller));
        barriers.add(new NormalWall("normal.jpg",560,700,controller));
        barriers.add(new NormalWall("normal.jpg",560,640,controller));

    }

}
