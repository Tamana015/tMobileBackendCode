package com.deutsche.telco.exceptions;

import com.deutsche.telco.enums.ErrorCode;

public class WrongPasswordException extends BaseException{
    public WrongPasswordException(String message){
        super(message);
        this.errorMessage = ErrorCode.WRONG_PASSWORD.getErrorMsg();
        this.errorCode = ErrorCode.WRONG_PASSWORD.getErrorCode();
    }
}