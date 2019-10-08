package com.wz.springboot.exception;

public class ApiNotFindAddressException extends ApiException{

    public ApiNotFindAddressException(String message) {
        super(AddressErrorCode.NotFindUserErrorCode,message, null);
    }
}
