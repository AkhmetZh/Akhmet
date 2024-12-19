class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String Title() {
        return title;
    }
    public String Author() {
        return author;
    }
    public void display() {
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
    }
}
class LibraryUser {
    private String name;
    public LibraryUser(String name) {
        this.name = name;
    }
    public String Name() {
        return name;
    }
    public void display() {
        System.out.println("User Name: " + name);
    }
}
class Library {
    private Book book;
    private LibraryUser user;
    public Library(Book book, LibraryUser user) {
        this.book = book;
        this.user = user;
    }
    public void display() {
        System.out.println("=== Library Details ===");
        user.display();
        book.display();
    }
}

class DigitalLibrarySystem {
    public static void main(String[] args) {
        Book book = new Book("Murder on the Orient Express", "Agatha Christie");
        LibraryUser user = new LibraryUser("Akhmet");
        Library library = new Library(book, user);
        library.display();
    }
}

