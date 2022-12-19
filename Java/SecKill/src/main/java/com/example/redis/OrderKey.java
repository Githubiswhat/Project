package com.example.redis;


public class OrderKey extends BasePrefix {

    public static OrderKey getSeckillOrderByUidGid = new OrderKey("seckill");

    public OrderKey(String prefix) {
        super(prefix);
    }
}
