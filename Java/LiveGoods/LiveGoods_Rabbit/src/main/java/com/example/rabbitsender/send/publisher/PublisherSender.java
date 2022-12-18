package com.example.rabbitsender.send.publisher;

import com.example.commons.message.LiveGoodsMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublisherSender {
    private final AmqpTemplate amqpTemplate;

    /**
     * 同步消息发送方法。 消息的消费者不返回，当前方法不结束
     *
     * @param exchange   交换器名称
     * @param routingKey 路由键
     * @param message    要发送的消息对象
     * @return
     */
    public Boolean sendMessageSync(String exchange, String routingKey, LiveGoodsMessage message) {
        return (Boolean) amqpTemplate.convertSendAndReceive(exchange, routingKey, message);
    }

    /**
     * 异步消息发送方法。 消息发送立刻返回。不等待消费者处理。
     *
     * @param exchange
     * @param routingKey
     * @param message
     */
    public void sendMessageAsync(String exchange, String routingKey, LiveGoodsMessage message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }
}
