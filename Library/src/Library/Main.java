package Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = DatabaseManager.getInstance();
        Library library = new Library();

        while (true) {
            System.out.println("\n1 - Add Regular Book");
            System.out.println("2 - Add EBook");
            System.out.println("3 - Display Books");
            System.out.println("4 - Update Book");
            System.out.println("5 - Delete Book");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            if (choice == 1 || choice == 2) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                String fileFormat = (choice == 2) ? scanner.nextLine() : null;

                Book book = BookFactory.createBook(choice, title, author, fileFormat);
                library.addBook(book);
                dbManager.insertBook(book);
                System.out.println("Book added!");
            } else if (choice == 3) {
                dbManager.displayBooks();
            } else if (choice == 4 || choice == 5) {
                System.out.print("Book ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                if (choice == 4) {
                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("New File Format (or empty): ");
                    String newFileFormat = scanner.nextLine();
                    dbManager.updateBook(id, newTitle, newAuthor, newFileFormat);
                } else {
                    dbManager.deleteBook(id);
                }
            }
        }

        dbManager.close();
        scanner.close();
    }
}
