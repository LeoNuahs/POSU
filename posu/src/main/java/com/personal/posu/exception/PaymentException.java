package com.personal.posu.exception;

import com.personal.posu.types.ExceptionType;

public class PaymentException extends Exception{
    private final ExceptionType exceptionType;

    public PaymentException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }

    public PaymentException(String orderId, ExceptionType exceptionType) {
        super(exceptionType.getMessage() + orderId);
        this.exceptionType = exceptionType;
    }

    public String getErrorId() {
        return exceptionType.getId().toString();
    }
}
