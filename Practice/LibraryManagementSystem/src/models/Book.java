package models;

public class Book {
    public static int nextBookId = 1;

    final private int id;
    final private String title;
    final private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.id = nextBookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;

        nextBookId++;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book [id=" + this.id + ", title='" + this.title + "', author='" + this.author + "', " +
                (this.isAvailable ? "available]" : "unavailable]");
    }
}