package Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        DatabaseManager dbManager = new DatabaseManager();

        while (true) {
            System.out.println("\nEnter the type of book to add (1 for Regular Book, 2 for EBook, 3 to display database books, 0 to exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            if (choice == 3) {
                System.out.println("\nBooks in the Database:");
                dbManager.displayBooks();
                continue;
            }

            System.out.print("Title of the book: ");
            String title = scanner.nextLine();

            System.out.print("Author of the book: ");
            String author = scanner.nextLine();

            Book book = null;

            if (choice == 1) {
                book = new RegularBook(title, author);
            } else if (choice == 2) {
                System.out.print("File format of the ebook (e.g., PDF, EPUB): ");
                String fileFormat = scanner.nextLine();
                book = new EBook(title, author, fileFormat);
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            library.addBook(book);
            dbManager.insertBook(book);
        }

        System.out.println("\nBooks in the Library:");
        library.displayBooks();

        scanner.close();
        dbManager.close();
    }
}
