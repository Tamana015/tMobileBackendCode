package com.deutsche.telco.controller;

import com.deutsche.telco.dto.*;
import com.deutsche.telco.enums.ErrorCode;
import com.deutsche.telco.model.User;
import com.deutsche.telco.service.AccountService;
import com.deutsche.telco.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

import static com.deutsche.telco.constants.StringConstants.SUCCESS_MESSAGE;

@RestController
@RequestMapping("/api/access")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OtpService otpService;

    @PostMapping("/signup")
    @PermitAll
    public ResponseDto<User> registerUser(@RequestBody SignupRequestDto signupRequestDto){
        User response = accountService.registerUser(signupRequestDto);
        return new ResponseDto<>(
                SUCCESS_MESSAGE,
                ErrorCode.SUCCESS.getErrorCode(),
                ErrorCode.SUCCESS.getErrorMsg(),
                response
        );
    }

    @GetMapping("/sendOtp")
    public ResponseDto<String> sendOtp(@RequestParam String email){
        String response = accountService.sendOtpToUserMailId(email);
        return new ResponseDto<>(
                SUCCESS_MESSAGE,
                ErrorCode.SUCCESS.getErrorCode(),
                ErrorCode.SUCCESS.getErrorMsg(),
                response
        );
    }

    @PostMapping("/otp-verify")
    public ResponseDto<String> otpVerify(@RequestBody OtpVerifyRequestDto otpVerifyRequestDto){
        String response = otpService.verifyOtp(otpVerifyRequestDto);
        return new ResponseDto<>(
                SUCCESS_MESSAGE,
                ErrorCode.SUCCESS.getErrorCode(),
                ErrorCode.SUCCESS.getErrorMsg(),
                response
        );
    }

    @PostMapping("/login")
    public ResponseDto<User> registerUser(@RequestBody LoginRequestDto loginRequestDto){
        User response = accountService.loginUser(loginRequestDto);
        return new ResponseDto<>(
                SUCCESS_MESSAGE,
                ErrorCode.SUCCESS.getErrorCode(),
                ErrorCode.SUCCESS.getErrorMsg(),
                response
        );
    }

}
