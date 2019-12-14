package com.team7.yourturn.data.map;

import com.team7.yourturn.module.game.data.BulletThroughWall;
import com.team7.yourturn.module.game.data.NormalWall;
import com.team7.yourturn.module.game.data.TankBase;
import com.team7.yourturn.module.game.data.UnDamageableWall;

import java.util.LinkedList;

public class CheckpointThree extends CheckpointMap{
    @Override
    public void mapInit() {
        barriers = new LinkedList<>();
        barriers.add(new NormalWall("normal.jpg",0,0,controller));
        barriers.add(new NormalWall("normal.jpg",60,0,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",120,0,controller));

        barriers.add(new BulletThroughWall("sea.jpg",300,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",240,300,controller));
        barriers.add(new BulletThroughWall("sea.jpg",360,300,controller));
        barriers.add(new NormalWall("normal.jpg",420,300,controller));
        barriers.add(new NormalWall("normal.jpg",480,300,controller));
        barriers.add(new NormalWall("normal.jpg",540,300,controller));
        barriers.add(new NormalWall("normal.jpg",180,300,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",600,300,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",660,300,controller));


        barriers.add(new BulletThroughWall("sea.jpg",300,540,controller));
        barriers.add(new BulletThroughWall("sea.jpg",240,540,controller));
        barriers.add(new BulletThroughWall("sea.jpg",180,540,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",120,540,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",360,540,controller));
        barriers.add(new NormalWall("normal.jpg",60,540,controller));
        barriers.add(new NormalWall("normal.jpg",420,540,controller));
        barriers.add(new NormalWall("normal.jpg",480,540,controller));
        barriers.add(new NormalWall("normal.jpg",660,540,controller));
        barriers.add(new NormalWall("normal.jpg",600,540,controller));
        barriers.add(new NormalWall("normal.jpg",540,540,controller));



        barriers.add(new BulletThroughWall("sea.jpg",120,180,controller));
        barriers.add(new BulletThroughWall("sea.jpg",60,180,controller));
        barriers.add(new BulletThroughWall("sea.jpg",180,180,controller));

        barriers.add(new BulletThroughWall("sea.jpg",480,180,controller));
        barriers.add(new BulletThroughWall("sea.jpg",540,180,controller));
        barriers.add(new BulletThroughWall("sea.jpg",600,180,controller));
        barriers.add(new NormalWall("normal.jpg",660,180,controller));
        barriers.add(new NormalWall("normal.jpg",720,180,controller));
        barriers.add(new NormalWall("normal.jpg",780,180,controller));
        barriers.add(new NormalWall("normal.jpg",840,180,controller));
        barriers.add(new NormalWall("normal.jpg",900,180,controller));


        barriers.add(new BulletThroughWall("sea.jpg",480,420,controller));
        barriers.add(new BulletThroughWall("sea.jpg",540,420,controller));
        barriers.add(new BulletThroughWall("sea.jpg",600,420,controller));
        barriers.add(new NormalWall("normal.jpg",720,420,controller));
        barriers.add(new NormalWall("normal.jpg",240,420,controller));
        barriers.add(new NormalWall("normal.jpg",300,420,controller));
        barriers.add(new NormalWall("normal.jpg",360,420,controller));
        barriers.add(new NormalWall("normal.jpg",420,420,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",660,420,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",120,420,controller));
        barriers.add(new UnDamageableWall("unbreakable.jpg",180,420,controller));

        barriers.add(new BulletThroughWall("sea.jpg",720,540,controller));
        barriers.add(new BulletThroughWall("sea.jpg",780,540,controller));
        barriers.add(new NormalWall("normal.jpg",900,540,controller));
        barriers.add(new BulletThroughWall("sea.jpg",840,540,controller));

        barriers.add(new TankBase("flag.jpg",500,700,controller));
        barriers.add(new NormalWall("normal.jpg",500,640,controller));
        barriers.add(new NormalWall("normal.jpg",440,640,controller));
        barriers.add(new NormalWall("normal.jpg",440,700,controller));
        barriers.add(new NormalWall("normal.jpg",560,700,controller));
        barriers.add(new NormalWall("normal.jpg",560,640,controller));
    }
}
