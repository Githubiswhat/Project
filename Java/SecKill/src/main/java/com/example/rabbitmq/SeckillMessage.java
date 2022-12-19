package com.example.rabbitmq;

import com.example.bean.User;
import lombok.Data;


@Data
public class SeckillMessage {
    private User user;
    private long goodsId;
}
