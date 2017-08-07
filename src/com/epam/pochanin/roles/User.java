package com.epam.pochanin.roles;

import com.epam.pochanin.dao.TripsDAO;
import com.epam.pochanin.entities.Trip;
import com.epam.pochanin.servlets.LoginServlet;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Role role;
    private String userName;
    private ArrayList<Trip> cart = new ArrayList<>();
    private ArrayList<Trip> oldPurchase = new ArrayList<>();
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

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

            for (Trip item : trips) {
                if (item.getId() == id) {
                    cart.add(item);
                }
            }
        } catch (SQLException|ClassNotFoundException e) {
            logger.error("Ошибка при попытке подключения к базе данных test в User.java;");
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
