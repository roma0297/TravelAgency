package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.UsersDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddUserServlet", urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        try {
            if (UsersDAO.getInstance().addUser(userName, password)) {
                logger.info("New user " + userName + " was successfully added to database;");
                response.sendRedirect("trips");
            } else {
                response.sendRedirect("signUp?error=1");
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Ошибка при попытке подключения к базе данных test в AddUserServlet;");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
