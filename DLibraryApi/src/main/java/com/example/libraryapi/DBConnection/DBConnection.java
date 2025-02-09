package com.example.libraryapi.DBConnection;
import java.sql.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/Library";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "18181818";

    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

