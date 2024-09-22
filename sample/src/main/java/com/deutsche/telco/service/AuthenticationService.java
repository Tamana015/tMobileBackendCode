package com.deutsche.telco.service;

import com.deutsche.telco.model.User;

public interface AuthenticationService {
    String validateToken(String token);
}
