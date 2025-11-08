package models;

import java.util.ArrayList;
import java.time.LocalDate;

import models.Book;

public class Member {
    static int nextMemberId = 1;

    final private int id;
    final private String fullName;
    final private LocalDate joinDate;
    final private ArrayList<Book> borrowedBooks;

    public Member(String fullName) {
        LocalDate currentDate = LocalDate.now();

        this.id = nextMemberId;
        this.fullName = fullName;
        this.joinDate = currentDate;
        this.borrowedBooks = new ArrayList<>();

        nextMemberId++;
    }

    public String getFullName() {
        return this.fullName;
    }

    @Override
    public String toString() {
        return "Member [id=" + this.id + ", full name=" + this.fullName + ", join date=" + this.joinDate +
                ", borrowed books=" + this.borrowedBooks.toString() + "]";
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
}