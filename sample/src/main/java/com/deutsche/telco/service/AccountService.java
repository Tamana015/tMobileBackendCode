package com.deutsche.telco.service;

import com.deutsche.telco.dto.LoginRequestDto;
import com.deutsche.telco.dto.SignupRequestDto;
import com.deutsche.telco.dto.AccountResponseDto;
import com.deutsche.telco.model.User;

public interface AccountService {
    User registerUser(SignupRequestDto signupRequestDto);
    String sendOtpToUserMailId(String email);
    User loginUser(LoginRequestDto loginRequestDto);

}
