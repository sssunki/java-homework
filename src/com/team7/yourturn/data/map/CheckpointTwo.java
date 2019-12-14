package com.team7.yourturn.data.map;

import com.team7.yourturn.module.game.data.BulletThroughWall;
import com.team7.yourturn.module.game.data.NormalWall;
import com.team7.yourturn.module.game.data.TankBase;
import com.team7.yourturn.module.game.data.UnDamageableWall;

import java.util.LinkedList;

public class CheckpointTwo extends CheckpointMap{
    @Override
    public void mapInit() {
        barriers = new LinkedList<>();
        barriers.add(new UnDamageableWall("unbreakable.jpg",120,240,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",180,240,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",240,240,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",720,240,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",660,240,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",600,240,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",120,360,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",180,360,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",240,360,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",720,360,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",660,360,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",600,360,controller));
        barriers.add(new NormalWall("normal.jpg",0,300,controller));
        barriers.add(new NormalWall("normal.jpg",60,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",120,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",180,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",240,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",300,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",360,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",420,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",480,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",540,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",600,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",660,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",720,300,controller));
        barriers.add(new NormalWall("normal.jpg",780,300,controller));
        barriers.add(new NormalWall("normal.jpg",840,300,controller));
        barriers.add(new NormalWall("normal.jpg",900,300,controller));
        barriers.add(new TankBase("flag.jpg",500,700,controller));
        barriers.add(new NormalWall("normal.jpg",500,640,controller));
        barriers.add(new NormalWall("normal.jpg",440,640,controller));
        barriers.add(new NormalWall("normal.jpg",440,700,controller));
        barriers.add(new NormalWall("normal.jpg",560,700,controller));
        barriers.add(new NormalWall("normal.jpg",560,640,controller));


    }
}
