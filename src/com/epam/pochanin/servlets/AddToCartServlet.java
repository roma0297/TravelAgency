package com.epam.pochanin.servlets;

import com.epam.pochanin.product.ProductItem;
import com.epam.pochanin.roles.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserRole user = (UserRole) session.getAttribute("user");

        //System.out.println(request.getAttribute("id"));
        System.out.println(request.getParameter("id"));
        if (user == null) {
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            //response.sendRedirect("/authentification");
            //request.getRequestDispatcher("authentification").forward(request, response);
        }

        user.addToCart(Integer.parseInt(request.getParameter("id")));

        response.sendRedirect("trip?id="+request.getParameter("id"));

    }
}
