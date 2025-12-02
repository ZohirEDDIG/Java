package service;

import java.util.ArrayList;

import model.Book;

public class SimpleBookManager implements BookManager {
   private ArrayList<Book> books = new ArrayList<Book>();


    public void addBook(Book book) {
        books.add(book);
    }

    public void showAllBooks() {
        if (books.size() == 0) {
            System.out.println("There are no books");
        } else {
            System.out.println("==All Books==");
            for (Book book: books) {
                System.out.println(book);
            }
        }
    }

    public void showAvailableBooks() {
    }
    
    public void borrowBook() {
    }

    public void returnBook() {
    }

    public void showMyBorrowedBooks() {
    }
}