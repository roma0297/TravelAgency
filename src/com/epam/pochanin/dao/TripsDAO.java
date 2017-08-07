package com.epam.pochanin.dao;

import com.epam.pochanin.entities.Trip;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripsDAO {
    private static TripsDAO ourInstance = new TripsDAO();

    public static TripsDAO getInstance() {
        return ourInstance;
    }

    private TripsDAO() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1h6dxlei0Q");

//        Connection connection = null;
//        InitialContext initContext= null;
//        try {
//            initContext = new InitialContext();
//            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/travelAgency");
//            connection = ds.getConnection();
//            return connection;
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        return connection;
    }

    public List<Trip> getTrips() throws SQLException, ClassNotFoundException {
        List<Trip> trips = new ArrayList<>();
        List<String> feautres;
        List<String> imageURLs;

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id, price, title, shortDescription, fullDescription FROM trips");
        ) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int price = resultSet.getInt(2);
                String title = resultSet.getString(3);
                String shortDescription = resultSet.getString(4);
                String fullDescription = resultSet.getString(5);

                trips.add(new Trip(id, price, title, shortDescription, fullDescription));
            }
        }

        for (Trip trip : trips) {
            feautres = new ArrayList<>();
            imageURLs = new ArrayList<>();

            try (Connection c = getConnection();
                 PreparedStatement ps1 = c.prepareStatement("SELECT feature FROM features WHERE trip_id = ?");
                 PreparedStatement ps2 = c.prepareStatement("SELECT imageURL FROM images WHERE trip_id = ?");
            ) {
                ps1.setInt(1, trip.getId());
                ResultSet resultSet = ps1.executeQuery();
                while (resultSet.next()) {
                    feautres.add(resultSet.getString(1));
                }

                ps2.setInt(1, trip.getId());
                resultSet = ps2.executeQuery();
                while (resultSet.next()) {
                    imageURLs.add(resultSet.getString(1));
                }

                trip.setFeatures(feautres);
                trip.setPictureURLs(imageURLs);
            }
        }

        return trips;
    }

    public void deleteTrip(int id) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps1 = c.prepareStatement("DELETE FROM trips WHERE id=?;");
             PreparedStatement ps2 = c.prepareStatement("DELETE FROM images WHERE trip_id=?;");
             PreparedStatement ps3 = c.prepareStatement("DELETE FROM features WHERE trip_id=?;");
        ) {
            ps1.setInt(1, id);
            ps2.setInt(1, id);
            ps3.setInt(1, id);
            ps1.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();
        }
    }

    public void addTrip(Trip newTrip) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             //PreparedStatement ps = c.prepareStatement("INSERT INTO items (price, title, shortDescription, fullDescription, feature1, feature2, feature3, feature4, feature5, pictureUrl1, pictureUrl2, pictureUrl3, pictureUrl4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
             PreparedStatement ps = c.prepareStatement("INSERT INTO trips (price, title, shortDescription, fullDescription) VALUES (?, ?, ?, ?)");
        ) {
            ps.setInt(1, newTrip.getPrice());
            ps.setString(2, newTrip.getTitle());
            ps.setString(3, newTrip.getShortDescription());
            ps.setString(4, newTrip.getFullDescription());
            ps.executeUpdate();
            int id = TripsDAO.getInstance().getTrips().get(TripsDAO.getInstance().getTrips().size() - 1).getId();
            newTrip.setId(id);

            PreparedStatement ps1 = c.prepareStatement("INSERT INTO features (feature, trip_id) VALUES (?, ?)");
            for (String feature : newTrip.getFeatures()) {
                ps1.setString(1, feature);
                ps1.setInt(2, newTrip.getId());
                ps1.executeUpdate();
            }

            PreparedStatement ps2 = c.prepareStatement("INSERT INTO images (imageURL, trip_id) VALUES (?, ?)");
            for (String imageURL : newTrip.getPictureURLs()) {
                ps2.setString(1, imageURL);
                ps2.setInt(2, newTrip.getId());
                ps2.executeUpdate();
            }
        }
    }

    public void addPurchases(String userName, List<Trip> purchases) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO purchases (price, title, shortDescription, user_name) VALUES (?, ?, ?, ?)");
        ) {
            for (Trip trip : purchases) {
                ps.setInt(1, trip.getPrice());
                ps.setString(2, trip.getTitle());
                ps.setString(3, trip.getShortDescription());
                ps.setString(4, userName);
                ps.executeUpdate();
            }
        }
    }

    public List<Trip> getPurchasesByUserName(String userName) throws SQLException, ClassNotFoundException {
        List<Trip> purchases = new ArrayList<>();

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT price, title, shortDescription FROM purchases WHERE user_name = ?");
        ) {
            ps.setString(1, userName);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int price = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String shortDescription = resultSet.getString(3);

                purchases.add(new Trip(price, title, shortDescription));
            }
        }

        return purchases;
    }
}
