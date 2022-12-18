package com.example.rabbitsender.send.publisher.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class PublisherConfig {
    @Value("${buy-action.rabbitmq.exchange}")
    private String exchange;
    @Value("${buy-action.rabbitmq.routeKey}")
    private String routeKey;
    @Value("${buy-action.rabbitmq.queue}")
    private String itemQueue;

    @Bean
    public Queue itemQueue() {
        return new Queue(itemQueue);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding contentBinding(Queue contentQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(contentQueue).to(directExchange).with(routeKey);
    }
}
