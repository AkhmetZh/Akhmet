package com.example.libraryapi.controller;

import com.example.libraryapi.entities.Book;
import com.example.libraryapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBooks() {
        try {
            return ResponseEntity.ok(bookService.getBooks());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        try {
            Book book = bookService.getBookById(id);
            return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookService.addBook(book));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookService.updateBook(book));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        try {
            return bookService.deleteBook(id) ?
                    ResponseEntity.ok("Book deleted.") :
                    ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}