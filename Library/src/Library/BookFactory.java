package Library;

public class BookFactory {
    public static Book createBook(int type, String title, String author, String fileFormat) {
        return switch (type) {
            case 1 -> new RegularBook(title, author);
            case 2 -> new EBook(title, author, fileFormat);
            default -> throw new IllegalArgumentException("Invalid book type");
        };
    }
}
