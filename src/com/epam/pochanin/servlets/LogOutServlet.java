package com.epam.pochanin.servlets;

import com.epam.pochanin.roles.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "com.epam.pochanin.servlets.LogOutServlet", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            switch (user.getRole()) {
                case ADMIN:
                    logger.info("Администратор \"" + user.getUserName() + "\" вышел из системы;");
                    break;
                case USER:
                    logger.info("Пользователь \"" + user.getUserName() + "\" вышел из системы;");
                    break;
                case TRAVEL_AGENT:
                    logger.info("Турагент \"" + user.getUserName() + "\" вышел из системы;");
                    break;
            }
        }

        request.getSession().invalidate();
        response.sendRedirect("trips");

    }
}
