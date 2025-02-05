package com.example.libraryapi.Interfaces;

import com.example.libraryapi.entities.Book;
import java.util.List;

public interface BookOperations {

    List<Book> readAllBooks();

    Book readBookById(int id);

    Book addBook(Book book);

    Book updateBook(Book book);

    boolean deleteBook(int id);
}
