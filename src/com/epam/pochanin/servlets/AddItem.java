package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.DAO;

import java.io.IOException;
import java.sql.SQLException;

@javax.servlet.annotation.WebServlet(name = "com.epam.pochanin.servlets.AddItem", urlPatterns = "/add")
public class AddItem extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //String txt = request.getParameter("txt");

        //int id = Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        String title = request.getParameter("title");
        String shortDescription = request.getParameter("shortDescription");
        String fullDescription = request.getParameter("fullDescription");
        String feature1 = request.getParameter("feature1");
        String feature2 = request.getParameter("feature2");
        String feature3 = request.getParameter("feature3");
        String feature4 = request.getParameter("feature4");
        String feature5 = request.getParameter("feature5");
        String pictureUrl1 = request.getParameter("pictureUrl1");
        String pictureUrl2 = request.getParameter("pictureUrl2");
        String pictureUrl3 = request.getParameter("pictureUrl3");
        String pictureUrl4 = request.getParameter("pictureUrl4");

        try {
            DAO.addPost(price, title, shortDescription, fullDescription, feature1, feature2, feature3, feature4, feature5, pictureUrl1, pictureUrl2, pictureUrl3, pictureUrl4);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/admin");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
