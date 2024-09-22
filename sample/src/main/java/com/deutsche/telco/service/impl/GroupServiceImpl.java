package com.deutsche.telco.service.impl;

import com.deutsche.telco.model.Cart;
import com.deutsche.telco.model.ParentCart;
import com.deutsche.telco.model.User;
import com.deutsche.telco.repository.ParentCartRepository;
import com.deutsche.telco.repository.UserRepository;
import com.deutsche.telco.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParentCartRepository parentCartRepository;

    private User addIntoGroup(int id, String mobileNumber) {
        Optional<User> userList = userRepository.findById(id);
        if(userList.isEmpty()) {
            throw new NotFoundException("User with given userId not found");
        }

        User user = userList.get();
        User user2 = userRepository.findByMobileNumber(mobileNumber);

        if(user2 == null){
            throw new NotFoundException("User not found with given mobile number. Please signup first with the mobile number");
        }

        ParentCart parentCart = user.getParentCart();
        List<Cart> cartList = parentCart.getCartList();

        cartList.add(user2.getCart());
        parentCart.setCartList(cartList);

        user.setParentCart(parentCart);

        return userRepository.save(user);
    }

    @Override
    public User addInGroup(int id, String mobileNumber) {
        return addIntoGroup(id, mobileNumber);
    }
}
