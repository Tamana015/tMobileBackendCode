package com.deutsche.telco.service.impl;

import com.deutsche.telco.model.TokenBlacklist;
import com.deutsche.telco.repository.TokenBlacklistRepository;
import com.deutsche.telco.service.AuthenticationService;
import com.deutsche.telco.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private TokenBlacklistRepository tokenBlackListRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String validateToken(String accessToken){
        TokenBlacklist blacklistedToken = tokenBlackListRepository.findByToken(accessToken);
        if(blacklistedToken!=null){
            return null;
        }
        if(jwtUtil.isTokenValid(accessToken)){
            return jwtUtil.getEmailFromToken(accessToken);
        }
        return null;
    }
}
