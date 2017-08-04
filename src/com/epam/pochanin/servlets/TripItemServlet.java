package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.DAO;
import com.epam.pochanin.product.ProductItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "com.epam.pochanin.servlets.TripItemServlet", urlPatterns = "/trip")
public class TripItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            for (ProductItem item: DAO.getTrips()) {
                if (item.getId() == id) {
                    request.setAttribute("trip", item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/views/trip.jsp").forward(request, response);
    }
}
