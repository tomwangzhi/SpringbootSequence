package com.wz.springboot.springbootannotation.exception;

import lombok.Data;

/**
 * 自定义异常类
 */
@Data
public class UserNotExistsException extends RuntimeException {

    private String id;
    private String message;

    public UserNotExistsException(String id,String message) {
        super();
        this.id = id;
        this.message = message;
    }


}
