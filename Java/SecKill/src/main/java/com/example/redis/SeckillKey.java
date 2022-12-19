package com.example.redis;


public class SeckillKey extends BasePrefix {
    public static SeckillKey isGoodsOver = new SeckillKey("go");

    private SeckillKey(String prefix) {
        super(prefix);
    }
}
