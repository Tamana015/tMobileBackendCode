package com.deutsche.telco.service.impl;

import com.deutsche.telco.model.*;
import com.deutsche.telco.repository.*;
import com.deutsche.telco.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

import static com.deutsche.telco.utils.Constants.DEVICEPLAN;
import static com.deutsche.telco.utils.Constants.RECHARGEPLAN;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private DevicePlanRespository devicePlanRespository;
    @Autowired
    private RechargePlanRepository rechargePlanRepository;
    @Autowired
    private ParentCartRepository parentCartRepository;

    @Autowired
    private UserRepository userRepository;

    private Cart getCartById(int cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found with given cartId"));
    }

    private Cart addItemToCart(int cartId, int itemId, String itemType ) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart with given id not found"));
        if(DEVICEPLAN.equalsIgnoreCase(itemType)){
            DevicePlan devicePlan = devicePlanRespository.findById(itemId).orElseThrow(() -> new NotFoundException("Device-Plan with given id not found"));
            List<DevicePlan> devicePlanList = cart.getDevicePlanList();
            devicePlanList.add(devicePlan);
            cart.setDevicePlanList(devicePlanList);
        }
        else if (RECHARGEPLAN.equalsIgnoreCase(itemType)) {
            RechargePlan rechargePlan = rechargePlanRepository.findById(itemId).orElseThrow(() -> new NotFoundException("Recharge-Plan with given id not found"));
            List<RechargePlan> rechargePlanList = cart.getRechargePlanList();
            rechargePlanList.add(rechargePlan);
            cart.setRechargePlanList(rechargePlanList);
        }
        return cartRepository.save(cart);
    }

    private ParentCart getParentCartForUser(int parentCartId) {
        Optional<ParentCart> parentCart = parentCartRepository.findById(parentCartId);
        if(parentCart.isEmpty()){
            throw new NotFoundException("Parent cart with given parentCartId not found");
        }
        return parentCart.get();
    }

    @Override
    public Cart getCart(int cartId) {
        return getCartById(cartId);
    }

    @Override
    public Cart addItemtoCart(int cartId, int itemId, String itemType) {
        return addItemToCart(cartId, itemId, itemType);
    }

    @Override
    public ParentCart getParentCart(int parentCartId) {
        return getParentCartForUser(parentCartId);
    }
}
