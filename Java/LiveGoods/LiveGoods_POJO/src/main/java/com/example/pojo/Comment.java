package com.example.pojo;

import lombok.Data;

/**
 * 商品评价实体
 */
@Data
public class Comment {
    private String id;
    // 用户名， 手机号
    private String username;
    // 评价信息
    private String comment;
    // 评分
    private int star;
    // 商品主键，是为哪一个商品做的评价。
    private String itemId;
}
