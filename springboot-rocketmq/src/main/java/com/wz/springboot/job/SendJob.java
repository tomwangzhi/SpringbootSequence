package com.wz.springboot.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendJob {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Scheduled(fixedDelay = 1000)
    public void send() {
        SendResult sendResult = rocketMQTemplate.syncSend("test", "test");
        log.info("send topic test message test success state ={}",sendResult.getMsgId());
    }
}
