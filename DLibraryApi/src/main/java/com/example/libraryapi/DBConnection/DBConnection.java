package com.example.libraryapi.DBConnection;
import java.sql.*;

public class DBConnection {
    protected String url = "jdbc:postgresql://localhost:5432/Library";
    protected String username = "postgres";
    protected String password = "18181818";

    public Connection connect() throws SQLException {
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database successfully.");
        return con;
    }

    public void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.close();
            System.out.println("Connection closed.");
        }
    }
}


