import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Book {
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

    public abstract void displayInfo();
}

class RegularBook extends Book {
    public RegularBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void displayInfo() {
        System.out.println("Regular Book [Title: " + getTitle() + ", Author: " + getAuthor() + "]");
    }
}

class EBook extends Book {
    private String fileFormat;

    public EBook(String title, String author, String fileFormat) {
        super(title, author);
        this.fileFormat = fileFormat;
    }

    @Override
    public void displayInfo() {
        System.out.println("EBook [Title: " + getTitle() + ", Author: " + getAuthor() + ", File Format: " + fileFormat + "]");
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                book.displayInfo();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nEnter the type of book to add (1 for Regular Book, 2 for EBook, 0 to exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            System.out.print("Title of the book: ");
            String title = scanner.nextLine();

            System.out.print("Author of the book: ");
            String author = scanner.nextLine();

            if (choice == 1) {
                Book regularBook = new RegularBook(title, author);
                library.addBook(regularBook);
            } else if (choice == 2) {
                System.out.print("File format of the ebook (e.g., PDF, EPUB): ");
                String fileFormat = scanner.nextLine();

                Book eBook = new EBook(title, author, fileFormat);
                library.addBook(eBook);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nBooks in the Library:");
        library.displayBooks();

        scanner.close();
    }
}
