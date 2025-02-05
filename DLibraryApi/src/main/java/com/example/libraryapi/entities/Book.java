package com.example.libraryapi.entities;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int publishedYear;

    public Book() {
    }

    public Book(int id, String title, String author, String genre, int publishedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedYear = publishedYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }
}

class BookReadOnly extends Book {

    public BookReadOnly(int id, String title, String author, String genre, int publishedYear) {
        super(id, title, author, genre, publishedYear);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public String getAuthor() {
        return super.getAuthor();
    }

    @Override
    public String getGenre() {
        return super.getGenre();
    }

    @Override
    public int getPublishedYear() {
        return super.getPublishedYear();
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setAuthor(String author) {

    }

    @Override
    public void setGenre(String genre) {

    }

    @Override
    public void setPublishedYear(int publishedYear) {

    }
}
