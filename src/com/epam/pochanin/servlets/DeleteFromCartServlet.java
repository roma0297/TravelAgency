package com.epam.pochanin.servlets;

import com.epam.pochanin.roles.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteFromCartServlet", urlPatterns = "/deleteFromCart")
public class DeleteFromCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserRole user = (UserRole) request.getSession().getAttribute("user");
        user.deleteFromCart(id);
        //request.getRequestDispatcher("/").forward(request, response);
        response.sendRedirect("account");
    }
}
