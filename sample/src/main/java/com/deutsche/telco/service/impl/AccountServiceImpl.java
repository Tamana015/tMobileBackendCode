package com.deutsche.telco.service.impl;

import com.deutsche.telco.dto.LoginRequestDto;
import com.deutsche.telco.dto.SignupRequestDto;
import com.deutsche.telco.dto.AccountResponseDto;
import com.deutsche.telco.exceptions.UserExistsException;
import com.deutsche.telco.exceptions.UserNotFoundException;
import com.deutsche.telco.exceptions.WrongPasswordException;
import com.deutsche.telco.model.Cart;
import com.deutsche.telco.model.ParentCart;
import com.deutsche.telco.model.User;
import com.deutsche.telco.repository.CartRepository;
import com.deutsche.telco.repository.ParentCartRepository;
import com.deutsche.telco.repository.UserRepository;
import com.deutsche.telco.service.AccountService;
import com.deutsche.telco.service.OtpService;
import com.deutsche.telco.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpService otpService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ParentCartRepository parentCartRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User registerUser(SignupRequestDto signupRequestDto) {
        Optional<User> user = userRepository.findUserByEmail(signupRequestDto.getEmail());
        if(user.isPresent()){
            throw new UserExistsException("User already exists");
        }
        User newUser = new User();
        newUser.setName(signupRequestDto.getName().trim());
        newUser.setMobileNumber(signupRequestDto.getPhone().trim());
        newUser.setEmail(signupRequestDto.getEmail());

        newUser.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        newUser.setIsActive(true);
        Cart cart = cartRepository.save(new Cart());
        ParentCart parentCart = new ParentCart();

        List<Cart> cartList = parentCart.getCartList()==null? new ArrayList<>():parentCart.getCartList();
        cartList.add(cart);
        parentCart.setCartList(cartList);

//        parentCart.setCartList(Arrays.asList(cart));
        newUser.setParentCart(parentCartRepository.save(parentCart));
        newUser.setCart(cart);
        userRepository.save(newUser);
        Optional<User> createdUserOpt = userRepository.findUserByEmail(signupRequestDto.getEmail());
        if(createdUserOpt.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        AccountResponseDto responseDto = new AccountResponseDto();
        User createdUser = createdUserOpt.get();
        responseDto.setEmail(createdUser.getEmail());
        responseDto.setName(createdUser.getName());
        String accessToken = jwtUtil.generateToken(newUser);
        responseDto.setAccessToken("");
        return createdUser;
    }

    @Override
    public String sendOtpToUserMailId(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        return otpService.sendOtpToEmail(user.get());
    }

    @Override
    public User loginUser(LoginRequestDto loginRequestDto) {
        Optional<User> user = userRepository.findUserByEmail(loginRequestDto.getEmail());
        if(Objects.isNull(user)){
            throw new UserNotFoundException("User not found");
        }
        User createdUser = user.get();
        if(!passwordEncoder.matches(loginRequestDto.getPassword(), createdUser.getPassword())){
            throw new WrongPasswordException("Wrong Password");
        }

        AccountResponseDto accountResponseDto = new AccountResponseDto();
        String accessToken = jwtUtil.generateToken(createdUser);
        accountResponseDto.setAccessToken(accessToken);
        accountResponseDto.setEmail(createdUser.getEmail());
        accountResponseDto.setName(createdUser.getName());
        return createdUser;
    }

}
