package com.epam.pochanin.roles;

import com.epam.pochanin.dao.DAO;
import com.epam.pochanin.product.ProductItem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRole {
    private ArrayList<ProductItem> cart = new ArrayList<>();
    private ArrayList<ProductItem> oldPurchase = new ArrayList<>();
    private boolean isAdmin;

    public ArrayList<ProductItem> getCart() {
        return cart;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public UserRole(boolean isAdmin, String userName) {
        this.isAdmin = isAdmin;
        this.userName = userName;
    }

    public ArrayList<ProductItem> getOldPurchase() {
        return oldPurchase;
    }

    public String getUserName() {
        return userName;
    }

    private String userName;

    public void addToCart (int id) {
        try {
            List<ProductItem> trips = DAO.getTrips();

            for (ProductItem item: trips) {
                if (item.getId() == id) {
                    cart.add(new ProductItem(item));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromCart (int id)
    {
        ProductItem productToRemove = null;

        for (ProductItem item: cart) {
            if (item.getId() == id) {
                productToRemove = item;
                break;
            }
        }

        if (productToRemove != null)
            cart.remove(productToRemove);
    }

    public void clearCart() {
        cart = new ArrayList<>();
    }
}
