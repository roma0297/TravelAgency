package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.UsersDAO;
import com.epam.pochanin.roles.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "com.epam.pochanin.servlets.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            User user = UsersDAO.getInstance().verifyUser(request.getParameter("username"), request.getParameter("password"));

            if (user == null) {
                response.sendRedirect("WEB-INF/views/error.jsp");
            } else {
                request.getSession().setAttribute("user", user);

                switch (user.getRole()) {
                    case ADMIN:
                        request.getSession().setAttribute("role", "admin");
                        response.sendRedirect("admin");
                        logger.info("Администратор \"" + user.getUserName() + "\" вошел в систему;");
                        break;
                    case USER:
                        request.getSession().setAttribute("role", "user");
                        response.sendRedirect("account");
                        logger.info("Пользователь \"" + user.getUserName() + "\" вошел в систему;");
                        break;
                    case TRAVEL_AGENT:
                        request.getSession().setAttribute("role", "agent");
                        response.sendRedirect("admin");
                        logger.info("Турагент \"" + user.getUserName() + "\" вошел в систему;");
                        break;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Ошибка при попытке подключения к базе данных test в LoginServlet;");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
