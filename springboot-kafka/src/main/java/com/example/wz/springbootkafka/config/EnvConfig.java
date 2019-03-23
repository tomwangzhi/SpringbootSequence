package com.example.wz.springbootkafka.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {


    public  String host;

    public  String kafakaHost;
    // kafaka主题 todo 这个主题是90服务器的主题消息
    //public static final String topiceName = "face-capture-wz";
    public String topiceName;

    @Value("${door.ban.system.url}")
    public  void setHost(String host) {
        this.host = host;
    }

    @Value("${door.ban.system.theme}")
    public void setTopiceName(String topiceName) {
        this.topiceName = topiceName;
    }

    @Value("${door.kafka.url}")
    public  void setKafakaHost(String kafakaHost) {
        this.kafakaHost = kafakaHost;
    }
}
