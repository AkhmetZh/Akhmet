import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        boolean addingBooks = true;
        while (addingBooks) {
            System.out.print("Book title: ");
            String title = scanner.nextLine();

            System.out.print("Book author: ");
            String author = scanner.nextLine();

            Book book = new Book(title, author);
            library.addBook(book);

            System.out.print("Add book?(yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                addingBooks = false;
            }
        }

        System.out.println("\nBooks in the Library:");
        library.displayBooks();

        System.out.print("\nYour name: ");
        String userName = scanner.nextLine();

        System.out.print("Your ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        LibraryUser user = new LibraryUser(userName, userId);
        System.out.println("\nLibrary User: " + user);

        scanner.close();
    }
}
