package com.example.libraryapi.Interfaces;

import com.example.libraryapi.entities.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class BookRepositoryImpl extends BaseBookRepository {

    public BookRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Book> getBooks(Connection con) {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM public.books";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("published_year")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getBookById(Connection con, int id) {
        String query = "SELECT * FROM public.books WHERE id = ?";
        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("genre"),
                            rs.getInt("published_year")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book addBook(Connection con, Book book) {
        String query = "INSERT INTO public.books (title, author, genre, published_year) VALUES (?, ?, ?, ?) RETURNING id";
        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setString(3, book.getGenre());
            st.setInt(4, book.getPublishedYear());

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    book.setId(rs.getInt(1));
                    return book;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book updateBook(Connection con, Book book) {
        String query = "UPDATE public.books SET title = ?, author = ?, genre = ?, published_year = ? WHERE id = ?";
        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setString(3, book.getGenre());
            st.setInt(4, book.getPublishedYear());
            st.setInt(5, book.getId());

            int success = st.executeUpdate();
            return success > 0 ? book : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteBook(Connection con, int id) {
        String query = "DELETE FROM public.books WHERE id = ?";
        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, id);
            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
