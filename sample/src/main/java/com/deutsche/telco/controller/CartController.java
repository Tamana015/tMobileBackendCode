package com.deutsche.telco.controller;

import com.deutsche.telco.model.Cart;
import com.deutsche.telco.model.ParentCart;
import com.deutsche.telco.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add-to-cart")
    @PermitAll
    public ResponseEntity<Cart> addToCart(@RequestParam int cartId, @RequestParam int itemId, @RequestParam String itemType){
        Cart cart = cartService.addItemtoCart(cartId, itemId, itemType);
        if(cart != null){
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-cart")
    @PermitAll
    public ResponseEntity<Cart> getCart(@RequestParam int cartId) {
        Cart cart = cartService.getCart(cartId);
        if(cart != null){
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-parent-cart")
    @PermitAll
    public ResponseEntity<ParentCart> getParentCart(@RequestParam int parentCartId) {
        ParentCart cart = cartService.getParentCart(parentCartId);
        if(cart != null){
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
