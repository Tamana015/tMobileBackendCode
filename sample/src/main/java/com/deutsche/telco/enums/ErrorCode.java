package com.deutsche.telco.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS(200, "Success"),
    USER_EXISTS(5000, "User already exists"),
    USER_NOT_FOUND(5001, "User not found"),
    OTP_NOT_FOUND(5002, "Otp not found"),
    WRONG_PASSWORD(5003, "Incorrect Password entered. Please enter again."),
    TOKEN_NOT_FOUND(5004, "Access Token not found");

    private final int errorCode;
    private final String errorMsg;

    ErrorCode(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.errorMsg = msg;
    }
}

