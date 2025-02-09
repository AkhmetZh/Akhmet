package com.example.libraryapi.Interfaces;

import com.example.libraryapi.entities.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseBookRepository implements BookRepository {
    protected final Connection connection;

    public BaseBookRepository(Connection connection) {
        this.connection = connection;
    }
}