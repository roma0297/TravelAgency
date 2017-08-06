package com.epam.pochanin;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class SQLConnection {

    private InitialContext ic;
    private DataSource ds;

    public static void main(String[] args) {
        try {
            Connection connection = (new SQLConnection()).getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException, NamingException	{
        ic = new InitialContext();
        ds = (DataSource) ic.lookup("java:/comp/env/jdbc/test"); // вместо написать java:/comp/env/jdbc/TestDB
        return ds.getConnection();

    }

}