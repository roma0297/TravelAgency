package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.DAO;
import com.epam.pochanin.roles.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserRole user = (UserRole) session.getAttribute("user");

        if (user != null) {
            response.sendRedirect("/WEB-INF/views/error.jsp");
        }

        request.getRequestDispatcher("WEB-INF/views/signUp.jsp").forward(request, response);
    }
}
