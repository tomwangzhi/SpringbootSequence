package com.wz.springboot.exception;

public class UserNotFindException extends RuntimeException {

    public UserNotFindException() {
        super("找不到此用户");
    }

    public UserNotFindException(String message) {
        super(message);
    }

}
