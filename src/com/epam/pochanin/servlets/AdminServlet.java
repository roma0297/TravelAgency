package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.TripsDAO;
import com.epam.pochanin.roles.Role;
import com.epam.pochanin.roles.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "com.epam.pochanin.servlets.AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            System.out.println(user);
            if (user == null) {
                request.getRequestDispatcher("authentification").forward(request, response);
            } else if (user.getRole() != Role.ADMIN) {
                response.sendRedirect("/WEB-INF/views/error.jsp");
            }

            request.setAttribute("trips", TripsDAO.getInstance().getTrips());
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(request, response);
    }
}
