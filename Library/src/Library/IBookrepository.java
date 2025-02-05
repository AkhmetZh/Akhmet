package Library;

interface IBookRepository {
    void insertBook(Book book);
    void updateBook(int id, String newTitle, String newAuthor, String newFileFormat);
    void deleteBook(int id);
    void displayBooks();
}
