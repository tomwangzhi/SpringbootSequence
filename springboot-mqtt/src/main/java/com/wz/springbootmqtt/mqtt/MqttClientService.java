package com.wz.springbootmqtt.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MqttClientService {

    private final static Logger logger = LoggerFactory.getLogger(MqttClientService.class);
    // 定义一些默认的初始化参数
    private  final static  String CLIENT_ID_DEFAULT = "ap";
    private final static int MQTT_VERSION=3;
    private final static boolean CLEAR_SERSSION_DEFAULT = true;

    // 订阅主题
    @Value("${deepeye.subscrible.topic}")
    private  String[] topic;

    // 发布主题
    @Value("${deepeye.publish.topic}")
    private   String pubTopic;
    // 定义实例化对象传进来的变量
    private  static String  clientId = CLIENT_ID_DEFAULT;
    // 服务端连接url
    @Value("${mqtt.uri}")
    private  String mqttServerUrl;
    // 客户端mqtt关键对象
    private  MqttClient mqttClient;
    // 用户名
    private String userName = "test";
    // 密码
    private char [] password = new char[] {'a','b'};

    public MqttClientService() {
    }

    public MqttClientService(String url,String clentId) {
        this.mqttServerUrl = url;
        this.clientId = clentId;
    }

    // 重用
    public MqttClientService(String mqttServerUrl) {
        this(mqttServerUrl,clientId);
    }

    // 开启订阅的方法
    public  void StartMqttSubscrible() {

        /**
         * MqttConnectOptions 包含一系列的mqtt连接服务端的行为信息参数
         * 1.KEEP_ALIVE_INTERVAL_DEFAULT = 60 s默认的保活时间间隔，如果不指定就默认的
         * 2.CONNECTION_TIMEOUT_DEFAULT = 30 s默认的连接超时时间，如果不指定就默认的
         * 3.CLEAN_SESSION_DEFAULT = true 默认清除会话设置，如果不指定
         * 4.MQTT_VERSION_DEFAULT = 0 默认的mqtt版本
         * 5. willMessage 设置的遗嘱消息 willDestination 遗嘱对应的主题
         * 6. SocketFactory
         * 7.Properties ssl连接相关属性参数
         */
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        // mqttConnectOptions.setConnectionTimeout(); 用默认的
        // mqttConnectOptions.setKeepAliveInterval(); 用默认的
        mqttConnectOptions.setUserName(userName);
        mqttConnectOptions.setPassword(password);
        mqttConnectOptions.setMqttVersion(MQTT_VERSION);
        mqttConnectOptions.setCleanSession(CLEAR_SERSSION_DEFAULT);
        // 这个如果设置的话就会将MqttClient传入的url覆盖掉
        //mqttConnectOptions.setServerURIs(new String[] {});
        // 与服务端连接异常中断时会往客户端发送的遗嘱消息
        byte[] exceptionNotice = "connect interrupt exception".getBytes();
        //mqttConnectOptions.setWill("0/#",exceptionNotice,0,true);
        MqttClient mqttClient = null;
        try {
            mqttClient = new MqttClient(mqttServerUrl,clientId,new MemoryPersistence());
            mqttClient.setCallback(new CustomerMqttCallBack());
            mqttClient.connect(mqttConnectOptions);
            mqttClient.subscribe(topic);
        } catch (MqttException e) {
            logger.error("mqtt connect or subscrible exception {}",e);
        }


    }

    // 发布消息的方法
    public void pushMessage(String message) {

        try {
            if(mqttClient == null) {
                mqttClient = new MqttClient(mqttServerUrl,clientId);
            }
            mqttClient.connect();
            mqttClient.publish(pubTopic,new MqttMessage(message.getBytes()));
        } catch (MqttException e) {
            logger.error("mqtt publish exception {}",e);
        }
        logger.info("-----------publish success message {}",new String(message.getBytes()));
    }

    // 重连
    public void reconnect() {
        try {
            if(mqttClient == null) {
                mqttClient = new MqttClient(mqttServerUrl,clientId);
            }
            mqttClient.connect();
        } catch (MqttException e) {
            logger.error("recconnect exception {}",e);
        }
    }
}
