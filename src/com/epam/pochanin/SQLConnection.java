package com.epam.pochanin;

import com.epam.pochanin.servlets.LoginServlet;
import org.apache.log4j.Logger;

import java.sql.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.sql.*;

public class SQLConnection {
    final static Logger logger = Logger.getLogger(LoginServlet.class.getName());

    private InitialContext ic;
    private DataSource ds;

    public static void main(String[] args) {
        try {
            Connection connection = (new SQLConnection()).getConnection();

        } catch (SQLException | NamingException e) {
            logger.error("Ошибка при подключении к базе данных");
        }
    }

    public Connection getConnection() throws SQLException, NamingException	{
        ic = new InitialContext();
        ds = (DataSource) ic.lookup("java:/comp/env/jdbc/test"); // вместо написать java:/comp/env/jdbc/TestDB
        return ds.getConnection();

    }

}