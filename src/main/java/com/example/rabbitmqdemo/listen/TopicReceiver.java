package com.example.rabbitmqdemo.listen;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 主题模式 消费者
 */
@Component
@RabbitListener(queues = "dcloud.topic.queue11")//监听的队列名称
public class TopicReceiver {

    @RabbitHandler
    public void process(Map message) {
        System.out.println("dcloud.topic.queue11消费者收到消息  : " + message.toString());
    }
}