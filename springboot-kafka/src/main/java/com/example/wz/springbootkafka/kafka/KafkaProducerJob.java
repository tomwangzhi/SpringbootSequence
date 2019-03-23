package com.example.wz.springbootkafka.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaProducerJob {

    @Autowired
    KafkaTemplate kafkaTemplate;
    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
        String data = "{\"faceUrl\":\"http://192.168.11.16/ifsrc/engine1/eng1store1_1/FaceWareHouse/src_0_3516/20190322/20190322T144316_116172_142697_9310_3516.jpg\",\"imageId\":\"3096253766450960\",\"cameraId\":\"3516\",\"imageUrl\":\"http://192.168.11.16/ifsrc/engine1/eng1store1_1/FaceWareHouse/src_0_3516/20190322/20190322T144316_116172_142697_9310_3516.jpg\",\"confidence\":\"0\",\"blackId\":\"0\",\"personId\":\"0\",\"id\":\"1473130\",\"time\":\"2019-03-14 17:06:48\",\"cameraName\":\"南山设备\"}";
        // 往对应的主题发送消息
        ListenableFuture alarm_record = kafkaTemplate.send("ALARM_RECORD", data);
        // 执行回调
        alarm_record.addCallback(new CallbackKafka());

    }
}
