package com.example.commons.message;

import lombok.Data;

// 购买商品的消息类型。
@Data
public class LiveGoodsBuyMessage extends LiveGoodsMessage {
    // 要购买的商品主键
    private String itemId;
    // 购买商品的用户
    private String username;
}
