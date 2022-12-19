package com.example.rabbitmq;


import com.example.bean.SeckillOrder;
import com.example.bean.User;
import com.example.redis.RedisService;
import com.example.service.GoodsService;
import com.example.service.OrderService;
import com.example.service.SeckillService;
import com.example.vo.GoodsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MQReceiver {

    private final GoodsService goodsService;

    private final OrderService orderService;

    private final SeckillService seckillService;


    @RabbitListener(queues = MQConfig.QUEUE)
    public void receive(String message) {
        log.info("receive message:" + message);
        SeckillMessage msg = RedisService.stringToBean(message, SeckillMessage.class);
        User user = msg.getUser();
        long goodsId = msg.getGoodsId();

        GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goodsVo.getStockCount();
        if (stock <= 0) {
            return;
        }

        //判断重复秒杀
        SeckillOrder order = orderService.getOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null) {
            return;
        }

        //减库存 下订单 写入秒杀订单
        seckillService.seckill(user, goodsVo);
    }

}
