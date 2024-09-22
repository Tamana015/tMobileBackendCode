package com.deutsche.telco.exceptions;

import com.deutsche.telco.enums.ErrorCode;

public class UserExistsException extends BaseException{
    public UserExistsException(String message){
        super(message);
        this.errorMessage = ErrorCode.USER_EXISTS.getErrorMsg();
        this.errorCode = ErrorCode.USER_EXISTS.getErrorCode();
    }
}
