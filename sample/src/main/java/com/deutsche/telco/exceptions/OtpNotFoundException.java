package com.deutsche.telco.exceptions;

import com.deutsche.telco.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class OtpNotFoundException extends BaseException{
    public OtpNotFoundException(String message){
        super(message);
        this.errorMessage = ErrorCode.OTP_NOT_FOUND.getErrorMsg();
        this.errorCode = ErrorCode.OTP_NOT_FOUND.getErrorCode();
    }
}
