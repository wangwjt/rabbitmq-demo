package com.example.rabbitmqdemo.listen;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 直连模式 消费者
 */
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称
public class DirectReceiver {

    @RabbitHandler
    public void process(Map message) {
        System.out.println("DirectReceiver消费者收到消息  : " + message.toString());
    }
}