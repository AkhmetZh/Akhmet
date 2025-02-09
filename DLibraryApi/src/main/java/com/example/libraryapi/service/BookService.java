package com.example.libraryapi.service;

import com.example.libraryapi.entities.Book;
import com.example.libraryapi.Interfaces.BookRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final Connection connection;
    private final BookValidator bookValidator;

    public BookService(BookRepository bookRepository, Connection connection, BookValidator bookValidator) {
        this.bookRepository = bookRepository;
        this.connection = connection;
        this.bookValidator = bookValidator;
    }


    public List<Book> getBooks() throws Exception {
        return bookRepository.getBooks(connection);
    }

    public Book getBookById(int id) throws Exception {
        return bookRepository.getBookById(connection, id);
    }

    public Book addBook(Book book) throws Exception {
        if (!bookValidator.validateBookDetails(book.getTitle(), book.getAuthor(), book.getPublishedYear())) {
            throw new IllegalArgumentException("Invalid book details");
        }
        return bookRepository.addBook(connection, book);
    }

    public Book updateBook(Book book) throws Exception {
        return bookRepository.updateBook(connection, book);
    }

    public boolean deleteBook(int id) throws Exception {
        return bookRepository.deleteBook(connection, id);
    }
}