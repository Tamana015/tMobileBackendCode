package com.deutsche.telco.service;

import com.deutsche.telco.dto.OtpVerifyRequestDto;
import com.deutsche.telco.model.User;

public interface OtpService {
    String sendOtpToEmail(User user);

    String sendOtpEmail(User user, int otp);

    String verifyOtp(OtpVerifyRequestDto otpVerifyRequestDto);

}
