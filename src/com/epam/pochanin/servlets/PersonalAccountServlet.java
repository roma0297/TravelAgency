package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.DAO;
import com.epam.pochanin.javaBeans.Cart;
import com.epam.pochanin.roles.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PersonalAccountServlet", urlPatterns = "/account")
public class PersonalAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            UserRole user = (UserRole) session.getAttribute("user");

            System.out.println(user);
            if (user == null) {
                //request.getRequestDispatcher("authentification").forward(request, response);
                response.sendRedirect("/authentification");
            }

            request.setAttribute("cart", user.getCart());
            if (user.getCart().isEmpty())
                request.setAttribute("isEmpty", true);
            request.setAttribute("oldPutchase", user.getOldPurchase());
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/views/personalAccount.jsp").forward(request, response);
    }
}
