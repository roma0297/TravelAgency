package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.DAO;
import com.epam.pochanin.roles.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "com.epam.pochanin.servlets.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //request.getSession().setMaxInactiveInterval(10);
            UserRole user = DAO.verifyUser(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);

            if (user.isAdmin()) {
                request.getSession().setAttribute("role", "admin");
                response.sendRedirect("/admin");
                //request.getRequestDispatcher("admin").forward(request, response);
                System.out.println("admin has logged in");
            }
            else
                response.sendRedirect("account");
                //request.getRequestDispatcher("WEB-INF/views/personalAccount.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
