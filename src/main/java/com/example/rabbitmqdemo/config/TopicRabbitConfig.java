package com.example.rabbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主题配置
 * 创建交换器、队列、路由键
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public TopicExchange topicExchange() {
        // 交换器名
        String exchangeName = "dcloud.topic";
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue topicQueueA() {
        // 队列名
        String QueueName = "dcloud.topic.queue10";
        return new Queue(QueueName);
    }

    @Bean
    public Queue topicQueueB() {
        // 队列名
        String QueueName = "dcloud.topic.queue11";
        return new Queue(QueueName);
    }

    @Bean
    public Binding bindingExchangeA(Queue topicQueueA, TopicExchange topicExchange) {
        // 路由键
        String routingKey = "com.ys";
        return BindingBuilder.bind(topicQueueA).to(topicExchange).with(routingKey);
    }

    //星号（*） ：只能匹配一个单词 井号（#）：可以匹配0个或多个单词
    @Bean
    public Binding bindingExchangeBA(Queue topicQueueB, TopicExchange topicExchange) {
        // 路由键
        String routingKey = "com.dzdy.#";
        return BindingBuilder.bind(topicQueueB).to(topicExchange).with(routingKey);
    }
}