package com.example.libraryapi.Interfaces;

import com.example.libraryapi.entities.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    List<Book> getBooks(Connection con);
    Book getBookById(Connection con, int id);
    Book addBook(Connection con, Book book);
    Book updateBook(Connection con, Book book) throws SQLException;
    boolean deleteBook(Connection con, int id);
}