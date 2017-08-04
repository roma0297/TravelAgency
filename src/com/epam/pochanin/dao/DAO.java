package com.epam.pochanin.dao;

import com.epam.pochanin.product.ProductItem;
import com.epam.pochanin.roles.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1h6dxlei0Q");
    }

    public static List<ProductItem> getTrips() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id, price, title, shortDescription, fullDescription, feature1, feature2, feature3, feature4, feature5, pictureUrl1, pictureUrl2, pictureUrl3, pictureUrl4  FROM items");

             ResultSet resultSet = ps.executeQuery();) {

            ArrayList<ProductItem> trips = new ArrayList<>();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                int price = resultSet.getInt(2);
                String title = resultSet.getString(3);
                String shortDescription = resultSet.getString(4);
                String fullDescription = resultSet.getString(5);
                String feature1 = resultSet.getString(6);
                String feature2 = resultSet.getString(7);
                String feature3 = resultSet.getString(8);
                String feature4 = resultSet.getString(9);
                String feature5 = resultSet.getString(10);
                String pictureUrl1 = resultSet.getString(11);
                String pictureUrl2 = resultSet.getString(12);
                String pictureUrl3 = resultSet.getString(13);
                String pictureUrl4 = resultSet.getString(14);


                trips.add(new ProductItem(id, price, title, shortDescription, fullDescription, feature1, feature2, feature3, feature4, feature5, pictureUrl1, pictureUrl2, pictureUrl3, pictureUrl4));
            }

            return trips;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE user = ? AND password = ? LIMIT 1;");
        ) {
            ps.setString(1, "user1");
            ps.setString(2, "12345");

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getBoolean(3));
            }
        }
    }

    public static void deletePost(int id) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM items WHERE id=?");
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public static void addPost(int price, String title, String shortDescription, String fullDescription, String feature1, String feature2, String feature3, String feature4, String feature5, String pictureUrl1, String pictureUrl2, String pictureUrl3, String pictureUrl4) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO items (price, title, shortDescription, fullDescription, feature1, feature2, feature3, feature4, feature5, pictureUrl1, pictureUrl2, pictureUrl3, pictureUrl4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ) {
            ps.setInt(1, price);
            ps.setString(2, title);
            ps.setString(3, shortDescription);
            ps.setString(4, fullDescription);
            ps.setString(5, feature1);
            ps.setString(6, feature2);
            ps.setString(7, feature3);
            ps.setString(8, feature4);
            ps.setString(9, feature5);
            ps.setString(10, pictureUrl1);
            ps.setString(11, pictureUrl2);
            ps.setString(12, pictureUrl3);
            ps.setString(13, pictureUrl4);
            ps.executeUpdate();
        }
    }

    public static UserRole verifyUser(String userName, String password) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE user = ? AND password = ? LIMIT 1;");
        ) {
            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return new UserRole(resultSet.getBoolean(3), userName);
            }
        }

        return null;
    }

    public static boolean addUser(String userName, String password) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps1 = c.prepareStatement("SELECT * FROM users WHERE user = ?");
             PreparedStatement ps2 = c.prepareStatement("INSERT INTO users (user, password, adminrole) VALUES (?, ?, 0)");
        ) {
            ps1.setString(1, userName);

            if (ps1.executeQuery().next())
                return false;
            else {
                ps2.setString(1, userName);
                ps2.setString(2, password);
                ps2.executeUpdate();
            }
        }

        return true;
    }

    public static void deleteUser(String userName) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM users WHERE user=?");
        ) {
            ps.setString(1, userName);
            ps.executeUpdate();
        }
    }

}
