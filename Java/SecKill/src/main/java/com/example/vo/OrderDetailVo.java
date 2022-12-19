package com.example.vo;

import com.example.bean.OrderInfo;
import lombok.Data;
@Data
public class OrderDetailVo {
    private GoodsVo goods;
    private OrderInfo order;
}
