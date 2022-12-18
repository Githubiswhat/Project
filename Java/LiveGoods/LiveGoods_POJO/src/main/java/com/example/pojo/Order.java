package com.example.pojo;

import lombok.Data;

@Data
public class Order {
    private String id;
    // 用户手机号
    private String username;
    // 商品主键
    private String itemId;
    // 商品标题
    private String title;
    // 房屋类型
    private String houseType;
    // 租赁方式
    private String rentType;
    // 价格
    private String price;
    // 图片地址
    private String img;
    // 是否已评论, 0-未评论； 2-已评论
    private int commentState;

    private String feedback;
}
