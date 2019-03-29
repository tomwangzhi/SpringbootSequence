package com.wz.springbootmqtt.mqtt;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.concurrent.atomic.AtomicLong;

@Component
public class CustomerMqttCallBack implements MqttCallback {

    @Autowired
    ApplicationContextProvider provider;


    @Autowired
    MqttClientService clientService;

    private static  ObjectMapper objectMapper = new ObjectMapper();
    private static  final Logger logger = LoggerFactory.getLogger(CustomerMqttCallBack.class);
    private static AtomicLong faceId = new AtomicLong();

    @Override
    public void connectionLost(Throwable cause) {

        logger.info("-----------开始重连-------");
        clientService.reconnect();
    }

    /**
     * mqtt 业务处理
     * @param topic
     * @param message
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {

        // 开始处理mqtt消息，并包装为客户需要的对象字符串

            clientService = ApplicationContextProvider.getApplicationContext().getBean(MqttClientService.class);
            logger.info("message arrive topic {}  message: {}",topic,  new String(message.getPayload()));
            byte[] data = message.getPayload();
            objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            JsonNode jsonNode = objectMapper.readTree(data);
            clientService.pushMessage("");



    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        logger.info("----------------receive message finished  {}",token.isComplete());
    }
}
