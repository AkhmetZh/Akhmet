package Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager implements IBookRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/Library";
    private static final String USER = "postgres";
    private static final String PASSWORD = "18181818";
    private static DatabaseManager instance;
    private Connection connection;
    private List<Book> books;

    private DatabaseManager() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            createTableIfNotExists();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
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

    @Override
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

    @Override
    public void updateBook(int id, String newTitle, String newAuthor, String newFileFormat) {
        String updateSQL = "UPDATE books SET title = ?, author = ?, file_format = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, newTitle);
            preparedStatement.setString(2, newAuthor);
            preparedStatement.setString(3, newFileFormat);
            preparedStatement.setInt(4, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Book updated successfully." : "Book not found.");
        } catch (SQLException e) {
            System.out.println("Failed to update book: " + e.getMessage());
        }
    }

    @Override
    public void deleteBook(int id) {
        String deleteSQL = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Book deleted successfully." : "Book not found.");
        } catch (SQLException e) {
            System.out.println("Failed to delete book: " + e.getMessage());
        }
    }

    @Override
    public void displayBooks() {
        String selectSQL = "SELECT * FROM books";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String fileFormat = resultSet.getString("file_format");

                if (fileFormat == null) {
                    System.out.println("ID: " + id + " | Regular Book [Title: " + title + ", Author: " + author + "]");
                } else {
                    System.out.println("ID: " + id + " | EBook [Title: " + title + ", Author: " + author + ", File Format: " + fileFormat + "]");
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
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        String selectSQL = "SELECT * FROM books";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String fileFormat = resultSet.getString("file_format");

                Book book = (fileFormat == null) ? new RegularBook(title, author) : new EBook(title, author, fileFormat);
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch books: " + e.getMessage());
        }
        return books;
    }

}