package com.team7.yourturn.data.map;

import com.team7.yourturn.module.game.data.BulletThroughWall;
import com.team7.yourturn.module.game.data.NormalWall;
import com.team7.yourturn.module.game.data.UnDamageableWall;

import java.util.LinkedList;

public class CheckpointThree extends CheckpointMap{
    @Override
    public void mapInit() {
        barriers = new LinkedList<>();
        barriers.add(new NormalWall("normal.jpg",0,0,controller));
        barriers.add(new BulletThroughWall("sea.jpg",300,300,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",120,0,controller));
    }
}
