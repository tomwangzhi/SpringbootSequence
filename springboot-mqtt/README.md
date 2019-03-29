### 各类说明
#### ApplicationContextProvider
该类是为了解决mqtt服务类无法注入回调类的问题，在回调类CustomerMqttCallBack
中采用application.getBean方法获取注册到容器中的bean

#### MqttClientService
该类为mqtt的服务类，包含了开启订阅，连接，以及发布消息等功能

#### CustomerMqttCallBack
该类是mqtt客户端连接上mqtt服务端后回调的类，会执行里面相应的方法
比如重连接方法，消息到达接收的方法

#### 也可以通过命令行或windows环境进行发布订阅
windows客户端推荐MQTTBOX