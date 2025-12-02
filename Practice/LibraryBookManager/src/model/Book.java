package model;

public class Book {
    private static int nextId = 1;

    private int id;
    private String title;
    private String author;
    private BookGenre genre;
    private int publishedIn;
    private BookStatus status; 

    public Book(String title, String author, BookGenre genre, int publishedIn) {
        this.id = nextId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedIn = publishedIn;
        this.status = BookStatus.AVAILABLE;
        nextId++;
    }

    public BookStatus getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "{id: " + this.id + ", title: " + this.title + ", author: " + this.author + ", genre: " + this.genre 
        + ", publishedIn: " + this.publishedIn + ", status: " + this.status; 
    }
}