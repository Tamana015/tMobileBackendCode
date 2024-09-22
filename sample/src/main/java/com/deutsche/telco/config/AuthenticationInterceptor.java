package com.deutsche.telco.config;

import com.deutsche.telco.exceptions.TokenNotFoundException;
import com.deutsche.telco.exceptions.UserNotFoundException;
import com.deutsche.telco.model.User;
import com.deutsche.telco.repository.UserRepository;
import com.deutsche.telco.service.AuthenticationService;
import com.deutsche.telco.utils.JwtUtil;
import com.deutsche.telco.utils.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;


@Component
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
            return true;
        }
//        String token;
//        try {
//            token = RequestContext.getAccessToken();
//        } catch (Exception e) {
//            throw new TokenNotFoundException("Invalid Access Token");
//        }
//
//        if (token == null) {
//            throw new TokenNotFoundException("Invalid Access Token");
//        }
//
//        String email = authenticationService.validateToken(token);
//
//        if (Objects.isNull(email))
//            throw new TokenNotFoundException("Invalid Access Token");
//        request.setAttribute(email, email);
//        Optional<User> createdUser = userRepo.findUserByEmail(email);
//        if (Objects.isNull(createdUser)) {
//            throw new UserNotFoundException("User not found");
//        }
//        if(!String.valueOf(createdUser.get().getId()).equals(jwtUtil.getUserIdFromToken(token))){
//            throw new UserNotFoundException("User not found");
//        }
        return true;
    }

}

