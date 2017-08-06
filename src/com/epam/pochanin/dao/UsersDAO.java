package com.epam.pochanin.dao;

import com.epam.pochanin.roles.Role;
import com.epam.pochanin.roles.User;

import java.sql.*;

public class UsersDAO {
    private static UsersDAO ourInstance = new UsersDAO();

    public static UsersDAO getInstance() {
        return ourInstance;
    }

    private UsersDAO() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1h6dxlei0Q");
    }

    public User verifyUser(String userName, String password) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE user = ? AND password = ? LIMIT 1;");
        ) {
            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                System.out.println("\n\n\n\n\n");
                System.out.println(Role.valueOf(resultSet.getString(3)));
                return new User(userName, Role.valueOf(resultSet.getString(3)));
            }
        }

        return null;
    }

    public boolean addUser(String userName, String password) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps1 = c.prepareStatement("SELECT * FROM users WHERE user = ?");
             PreparedStatement ps2 = c.prepareStatement("INSERT INTO users (user, password, role) VALUES (?, ?, 'USER')");
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

    public void deleteUser(String userName) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM users WHERE user=?");
        ) {
            ps.setString(1, userName);
            ps.executeUpdate();
        }
    }
}
