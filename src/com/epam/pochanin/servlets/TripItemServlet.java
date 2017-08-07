package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.TripsDAO;
import com.epam.pochanin.entities.Trip;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "com.epam.pochanin.servlets.TripItemServlet", urlPatterns = "/trip")
public class TripItemServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Trip item : TripsDAO.getInstance().getTrips()) {
                if (item.getId() == id) {
                    request.setAttribute("trip", item);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Ошибка при попытке подключения к базе данных test в TripItemServlet;");
        }

        request.getRequestDispatcher("WEB-INF/views/trip.jsp").forward(request, response);
    }
}
