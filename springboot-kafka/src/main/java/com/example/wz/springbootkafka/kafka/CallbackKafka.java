package com.example.wz.springbootkafka.kafka;

import org.springframework.util.concurrent.ListenableFutureCallback;

public class CallbackKafka implements ListenableFutureCallback {

    @Override
    public void onSuccess(Object o) {
        System.out.println("------------------成功发送------------");
    }

    @Override
    public void onFailure(Throwable throwable) {
        System.out.println("---------------------失败发送---------------");
    }
}
