### kafka使用

#### 步骤
1. 引入依赖
 <!--kafka依赖-->
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
            <version>1.0.0.RELEASE</version>
        </dependency>
        
        
2.消费端bean配置
详见：\config\KafkaConsumerConfig.java下的java文件

关键依赖的几个bean是，用@Bean注解 @Configuration注入
ConcurrentKafkaListenerContainerFactory(传入初始化好的ConsumerFactory)
->ConsumerFactory(传入初始化好参数的map)
->Map<String, Object>(需要初始化的一些参数)
->KafkaConsumerListener(需调用的监听器)

3.生产端配置
详见：com.example.wz.springbootkafka.config.KafkaProducerConfig

关键依赖的几个bean是
Map<String, Object>、DefaultKafkaProducerFactory KafkaTemplate

发送消息调用
KafkaTemplate中的send方法，也可以设置回调函数

