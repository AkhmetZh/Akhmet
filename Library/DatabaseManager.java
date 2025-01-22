package Library;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/Library";
    private static final String USER = "postgres";
    private static final String PASSWORD = "500407Aa";

    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            createTableIfNotExists();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS books (
                    id SERIAL PRIMARY KEY,
                    title VARCHAR(255) NOT NULL,
                    author VARCHAR(255) NOT NULL,
                    file_format VARCHAR(50)
                );
                """;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        }
    }

    public void insertBook(Book book) {
        String insertSQL = "INSERT INTO books (title, author, file_format) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());

            if (book instanceof EBook) {
                preparedStatement.setString(3, ((EBook) book).getFileFormat());
            } else {
                preparedStatement.setNull(3, Types.VARCHAR);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to insert book: " + e.getMessage());
        }
    }

    public void displayBooks() {
        String selectSQL = "SELECT * FROM books";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String fileFormat = resultSet.getString("file_format");

                if (fileFormat == null) {
                    System.out.println("Regular Book [Title: " + title + ", Author: " + author + "]");
                } else {
                    System.out.println("EBook [Title: " + title + ", Author: " + author + ", File Format: " + fileFormat + "]");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to display books: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close database connection: " + e.getMessage());
        }
    }
}
