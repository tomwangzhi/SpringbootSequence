package com.wz.springboot.springbootannotation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

// 全局异常处理类。这里针对controller中抛出的异常进行捕获
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistsException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> handleUserNotExitsException(UserNotExistsException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("id", ex.getId());
        map.put("message", ex.getMessage());
        return map;
    }
}
