package com.epam.pochanin.servlets;

import com.epam.pochanin.dao.TripsDAO;
import com.epam.pochanin.roles.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PersonalAccountServlet", urlPatterns = "/account")
public class PersonalAccountServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/authentification");
        }

        try {
            request.setAttribute("oldPurchases", TripsDAO.getInstance().getPurchasesByUserName(user.getUserName()));
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Ошибка при подключении к базе данных test в PersonalAccountServlet;");
        }

        request.setAttribute("cart", user.getCart());
        if (user.getCart().isEmpty())
            request.setAttribute("isEmpty", true);

        request.getRequestDispatcher("WEB-INF/views/personalAccount.jsp").forward(request, response);
    }
}
