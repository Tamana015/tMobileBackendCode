package com.deutsche.telco.service;

import com.deutsche.telco.model.Cart;
import com.deutsche.telco.model.ParentCart;

public interface CartService {

    Cart getCart(int cartId);
    Cart addItemtoCart(int cartId, int itemId, String itemType);
    ParentCart getParentCart(int parentCartId);

}
