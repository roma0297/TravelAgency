package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.TripsDAO;
import com.epam.pochanin.roles.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PayServlet", urlPatterns = "/pay")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("WEB-INF/views/error.jsp");
        }

        try {
            TripsDAO.getInstance().addPurchases(user.getUserName(), user.getCart());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        user.clearCart();
        response.sendRedirect("trips");
    }
}
