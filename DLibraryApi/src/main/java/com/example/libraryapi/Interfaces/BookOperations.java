package com.example.libraryapi.Interfaces;

import com.example.libraryapi.entities.Book;
import java.util.List;

public interface ReadOperations {
    List<Book> readAllBooks();
    Book readBookById(int id);
}

public interface WriteOperations {
    Book addBook(Book book);
    Book updateBook(Book book);
    boolean deleteBook(int id);
}

