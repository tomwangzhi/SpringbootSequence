package com.wz.springboot.producer;

import com.wz.springboot.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RocketMqProducer implements CommandLineRunner {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... args) throws Exception {
        Message<String> message = new Message<>();
        message.setId(UUID.randomUUID().toString());
        message.setContent("Hello, springboot-ac-rocketmq !");
        rocketMQTemplate.convertAndSend("topic-queue-one",message);
        rocketMQTemplate.convertAndSend("topic-queue-two","Hello, springboot-ac-rocketmq !");
    }
}
