
package com.example.libraryapi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.libraryapi.DBConnection.DBConnectionBook;
import com.example.libraryapi.entities.Book;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/books")
public class BookController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final DBConnectionBook dbBook = new DBConnectionBook();

    @GetMapping("/all")
    public String getBooks() {
        try (Connection con = dbBook.connect()) {
            return objectMapper.writeValueAsString(dbBook.getBooks(con));
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id) {
        try (Connection con = dbBook.connect()) {
            return objectMapper.writeValueAsString(dbBook.getBookById(con, id));
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
        try (Connection con = dbBook.connect()) {
            return objectMapper.writeValueAsString(dbBook.addBook(con, book));
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    @PutMapping("/update")
    public String updateBook(@RequestBody Book book) {
        try (Connection con = dbBook.connect()) {
            return objectMapper.writeValueAsString(dbBook.updateBook(con, book));
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        try (Connection con = dbBook.connect()) {
            return dbBook.deleteBook(con, id) ? "Book deleted." : "Failed to delete book.";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }
}
