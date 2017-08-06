package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.TripsDAO;
import com.epam.pochanin.product.Trip;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "com.epam.pochanin.servlets.AddItem", urlPatterns = "/add")
public class AddItemServlet extends javax.servlet.http.HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int price = Integer.parseInt(request.getParameter("price"));
        //String title = request.getParameter("title");
        //System.out.println(new String(title.getBytes("ISO-8859-1"), "UTF8"));
        //String shortDescription = request.getParameter("shortDescription");
        //String fullDescription = request.getParameter("fullDescription");
        String title = new String(request.getParameter("title").getBytes("ISO-8859-1"), "UTF8");
        String shortDescription = new String(request.getParameter("shortDescription").getBytes("ISO-8859-1"), "UTF8");
        String fullDescription = new String(request.getParameter("fullDescription").getBytes("ISO-8859-1"), "UTF8");

        List<String> features = new ArrayList<>();
        List<String> imageURLs = new ArrayList<>();

        for (int i = 1; ; i++) {
            String feature = request.getParameter("feature" + i);

            if (feature == null)
                break;

            feature = new String(feature.getBytes("ISO-8859-1"), "UTF8");

            features.add(feature);
        }

        for (int i = 1; ; i++) {
            String imageURL = request.getParameter("pictureUrl" + i);

            if (imageURL == null)
                break;

            imageURL = new String(imageURL.getBytes("ISO-8859-1"), "UTF8");

            imageURLs.add(imageURL);
        }

        try {
            TripsDAO.getInstance().addTrip(new Trip(price, title, shortDescription, fullDescription, features, imageURLs));
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Ошибка при попытке подключения к базе данных test в AddItemServlet;");
        }

        response.sendRedirect("/admin");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
