package com.epam.pochanin.javaBeans;

import com.epam.pochanin.product.ProductItem;

import java.util.ArrayList;

public class Cart {
    ArrayList<ProductItem> cartList = new ArrayList<>();

    public ArrayList<ProductItem> getCartList() {
        return cartList;
    }

    public void setCartList(ArrayList<ProductItem> cartList) {
        this.cartList = cartList;
    }

    public void addToCart (int id) {

    }

    public void deleteFromCart (int id) {

    }
}
