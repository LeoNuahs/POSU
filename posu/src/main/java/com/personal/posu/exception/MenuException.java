package com.personal.posu.exception;

import com.personal.posu.types.ExceptionType;

public class MenuException extends Exception{
    private final ExceptionType exceptionType;

    public MenuException(String orderId, ExceptionType exceptionType) {
        super(exceptionType.getMessage() + orderId);
        this.exceptionType = exceptionType;
    }

    public String getErrorId() {
        return exceptionType.getId().toString();
    }
}
