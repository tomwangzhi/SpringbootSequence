package com.example.wz.springbootkafka.config;

import com.example.wz.springbootkafka.kafka.KafkaConsumerListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *  Kafka消费者配置
 *
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Autowired
    EnvConfig envConfig;

    // 工厂beanconsumerFactory注入ConcurrentKafkaListenerContainerFactory
    @Bean
    ConcurrentKafkaListenerContainerFactory<String , String>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    // 配置消费端的工厂bean
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
    @Bean
    public Map<String, Object> consumerConfigs() {
        // 消费端需要配置的一些参数  对象名称为consumerConfigs注入到ConsumerFactory这个对象中去
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,envConfig.kafakaHost);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put("auto.commit.interval.ms", "1000");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,3000);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "5");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest" );
        return props;
    }
    @Bean// 配置消息监听器
    public KafkaConsumerListener myListener() {
        return new KafkaConsumerListener();
    }
}
