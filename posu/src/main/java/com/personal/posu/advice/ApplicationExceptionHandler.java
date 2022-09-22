package com.personal.posu.advice;

import com.personal.posu.exception.DatabaseException;
import com.personal.posu.exception.MenuException;
import com.personal.posu.exception.PaymentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DatabaseException.class)
    public Map<String, String> handleDatabaseException(DatabaseException ex) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put(ex.getErrorId(), ex.getMessage());

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MenuException.class)
    public Map<String, String> handleItemException(MenuException ex) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put(ex.getErrorId(), ex.getMessage());

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PaymentException.class)
    public Map<String, String> handlePaymentException(PaymentException ex) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put(ex.getErrorId(), ex.getMessage());

        return errorMap;
    }
}
