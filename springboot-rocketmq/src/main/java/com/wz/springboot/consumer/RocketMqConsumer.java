package com.wz.springboot.consumer;

import com.wz.springboot.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RocketMqConsumer {


    @Service
    @RocketMQMessageListener(topic = "topic-queue-one", consumerGroup = "consumer_topic-queue-one")
    public class ConsumerOne implements RocketMQListener<Message> {
        @Override
        public void onMessage(Message message) {
            log.info("consumer-one received message: {}", message);
        }
    }

    @Service
    @RocketMQMessageListener(topic = "topic-queue-two", consumerGroup = "consumer_topic-queue-two")
    public class ConsumerTwo implements RocketMQListener<String> {
        @Override
        public void onMessage(String message) {
            log.info("consumer-two received message: {}", message);
        }
    }


}
