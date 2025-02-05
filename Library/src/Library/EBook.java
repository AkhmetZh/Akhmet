package Library;

public class EBook extends Book {
    private String fileFormat;

    public EBook(String title, String author, String fileFormat) {
        super(title, author);
        this.fileFormat = fileFormat;
    }

    @Override
    public void displayInfo() {
        System.out.println("EBook [Title: " + getTitle() + ", Author: " + getAuthor() + ", File Format: " + fileFormat + "]");
    }

    public String getFileFormat() {
        return fileFormat;
    }
}
