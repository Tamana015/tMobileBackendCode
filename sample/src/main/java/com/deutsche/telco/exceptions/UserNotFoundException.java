package com.deutsche.telco.exceptions;

import com.deutsche.telco.enums.ErrorCode;

public class UserNotFoundException extends BaseException{
    public UserNotFoundException(String message){
        super(message);
        this.errorMessage = ErrorCode.USER_NOT_FOUND.getErrorMsg();
        this.errorCode = ErrorCode.USER_NOT_FOUND.getErrorCode();
    }
}
