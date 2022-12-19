package com.example.redis;


public abstract class BasePrefix implements KeyPrefix {

    private final int expireSeconds;

    private final String prefix;

    public BasePrefix(String prefix) {
        //默认0 代表永不过期
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();//拿到参数类类名
        return className + ":" + prefix;
    }
}
