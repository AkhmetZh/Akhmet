package Library;

public class RegularBook extends Book {
    public RegularBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void displayInfo() {
        System.out.println("Regular Book [Title: " + getTitle() + ", Author: " + getAuthor() + "]");
    }
}
