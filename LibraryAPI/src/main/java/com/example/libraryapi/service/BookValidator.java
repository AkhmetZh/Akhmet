package com.example.libraryapi.service;

import org.springframework.stereotype.Component;

@Component
public class BookValidator {

    public boolean validateBookDetails(String title, String author, int publishedYear) {
        return title != null && !title.isEmpty() && author != null && !author.isEmpty() && publishedYear > 0;
    }
}
