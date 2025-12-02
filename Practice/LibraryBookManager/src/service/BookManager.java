package service;

import model.Book;

public interface BookManager {
    void addBook(Book book);
    void showAllBooks();
    void showAvailableBooks();
    void borrowBook();
    void returnBook();
    void showMyBorrowedBooks();
}