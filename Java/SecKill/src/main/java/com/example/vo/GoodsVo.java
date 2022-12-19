package com.example.vo;

import com.example.bean.Goods;
import lombok.Data;

import java.util.Date;


@Data
public class GoodsVo extends Goods {
    private Double seckillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
    private Integer version;
}

