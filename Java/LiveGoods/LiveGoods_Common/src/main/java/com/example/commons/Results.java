package com.example.commons;

import lombok.Data;


@Data
public class Results {
    private int status;
    private Object results;
    private String msg;
    private Object data;
    private boolean hasMore;
    private long time;

    public static Results ok() {
        Results result = new Results();
        result.setStatus(200);
        return result;
    }

    public static Results ok(Object data) {
        Results result = new Results();
        result.setStatus(200);
        result.setData(data);
        return result;
    }

    public static Results error() {
        Results result = new Results();
        result.setStatus(500);
        return result;
    }

    public static Results error(String msg) {
        Results result = new Results();
        result.setStatus(500);
        result.setMsg(msg);
        return result;
    }

}
