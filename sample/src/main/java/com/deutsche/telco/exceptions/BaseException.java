package com.deutsche.telco.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@NoArgsConstructor
public class BaseException extends RuntimeException{

    protected Integer errorCode;
    protected String errorMessage;

    public BaseException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}

