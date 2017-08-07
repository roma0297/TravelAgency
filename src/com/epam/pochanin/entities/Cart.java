package com.epam.pochanin.entities;

import java.util.ArrayList;

public class Cart {
    ArrayList<Trip> cartList = new ArrayList<>();

    public ArrayList<Trip> getCartList() {
        return cartList;
    }

    public void setCartList(ArrayList<Trip> cartList) {
        this.cartList = cartList;
    }

    public void addToCart(int id) {

    }

    public void deleteFromCart(int id) {

    }
}
