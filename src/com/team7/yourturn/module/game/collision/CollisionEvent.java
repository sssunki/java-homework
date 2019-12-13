package com.team7.yourturn.module.game.collision;

import com.team7.yourturn.data.base.Item;

public class CollisionEvent {

    private Item producer;
    private Item consumers;
    private int consumerX;
    private int consumerY;

    public CollisionEvent(Item producer, int consumerX, int consumerY) {
        this.producer = producer;
        this.consumerX = consumerX;
        this.consumerY = consumerY;
    }

    public CollisionEvent(Item producer, Item consumers) {
        this.producer = producer;
        this.consumers = consumers;
    }

    public int getConsumerX() {
        return consumerX;
    }

    public void setConsumerX(int consumerX) {
        this.consumerX = consumerX;
    }

    public int getConsumerY() {
        return consumerY;
    }

    public void setConsumerY(int consumerY) {
        this.consumerY = consumerY;
    }

    public Item getProducer() {
        return producer;
    }

    public void setProducer(Item producer) {
        this.producer = producer;
    }

    public Item getConsumers() {
        return consumers;
    }

    public void setConsumers(Item consumers) {
        this.consumers = consumers;
    }
}
