import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DigitalLibrarySystem system = new DigitalLibrarySystem();
        system.run();
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
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

    public String getName() {
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
    public void run() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Book title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Book author: ");
        String bookAuthor = scanner.nextLine();
        Book book = new Book(bookTitle, bookAuthor);


        System.out.print("User name: ");
        String userName = scanner.nextLine();
        LibraryUser user = new LibraryUser(userName);

        Library library = new Library(book, user);
        library.display();

        scanner.close();
    }
}


