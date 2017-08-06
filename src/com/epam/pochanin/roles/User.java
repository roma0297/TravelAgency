package com.epam.pochanin.roles;

import com.epam.pochanin.dao.TripsDAO;
import com.epam.pochanin.product.Trip;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Role role;
    private String userName;
    private ArrayList<Trip> cart = new ArrayList<>();
    private ArrayList<Trip> oldPurchase = new ArrayList<>();

    public ArrayList<Trip> getCart() {
        return cart;
    }

    public Role getRole() {
        return role;
    }

    public User(String userName, Role role) {
        this.role = role;
        this.userName = userName;
    }


    public ArrayList<Trip> getOldPurchase() {
        return oldPurchase;
    }

    public String getUserName() {
        return userName;
    }

    public void addToCart(int id) {
        try {
            List<Trip> trips = TripsDAO.getInstance().getTrips();
            System.out.println(trips);

            for (Trip item : trips) {
                if (item.getId() == id) {
                    cart.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromCart(int id) {
        Trip productToRemove = null;

        for (Trip item : cart) {
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
