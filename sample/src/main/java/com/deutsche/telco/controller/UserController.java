package com.deutsche.telco.controller;

import com.deutsche.telco.dto.ResponseDto;
import com.deutsche.telco.model.User;
import com.deutsche.telco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userDetails")
    @PermitAll
    public List<User>getUserDetails(){
        List<User> user = userRepository.findAll();
        return user;
    }
}
