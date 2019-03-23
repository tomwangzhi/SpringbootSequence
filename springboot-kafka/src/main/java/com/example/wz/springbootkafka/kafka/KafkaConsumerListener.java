package com.example.wz.springbootkafka.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumerListener {

    // 一旦这个注解配置的主题有消息后就会调用该方法进行消费
    @KafkaListener(topics = {"ALARM_RECORD"})
    public void Listen(ConsumerRecord<?, ?> record) {

        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.offset());
        System.out.println(record.partition());
    }
}
