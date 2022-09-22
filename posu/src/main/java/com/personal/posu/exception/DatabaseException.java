package com.personal.posu.exception;

import com.personal.posu.types.ExceptionType;
import lombok.Getter;

@Getter
public class DatabaseException extends Exception{
    private final ExceptionType exceptionType;

    public DatabaseException(String recordId, ExceptionType exceptionType) {
        super(exceptionType.getMessage() + recordId);
        this.exceptionType = exceptionType;
    }

    public DatabaseException(Throwable cause, ExceptionType exceptionType) {
        super(exceptionType.getMessage(), cause);
        this.exceptionType = exceptionType;
    }

    public String getErrorId() {
        return exceptionType.getId().toString();
    }
}
