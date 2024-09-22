package com.deutsche.telco.exceptions;

import com.deutsche.telco.enums.ErrorCode;

public class TokenNotFoundException extends BaseException{
    public TokenNotFoundException(String message){
        super(message);
        this.errorMessage = ErrorCode.TOKEN_NOT_FOUND.getErrorMsg();
        this.errorCode = ErrorCode.TOKEN_NOT_FOUND.getErrorCode();
    }
}
