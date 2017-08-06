package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.TripsDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "com.epam.pochanin.servlets.MyServlet", urlPatterns = "/trips")
public class TripsServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("trips", TripsDAO.getInstance().getTrips());
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Ошибка при подключении к базе данных test в TripsServlet;");
        }

        request.getRequestDispatcher("WEB-INF/views/trips.jsp").forward(request, response);
    }
}
