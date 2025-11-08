package system;

import java.util.ArrayList;
import java.util.Scanner;

import models.Book;
import models.Member;

public class LibraryManagement {
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<Member> members = new ArrayList<>();
    public static int borrowedBooks = 0;

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void showAllBooks() {
        for (Book book: books) {
            System.out.println(book);
        }
    }

    public void showAvailableBooks() {
        System.out.println("Available books: ");
        for (Book book: books) {
            if (book.getIsAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void showMembers() {
        for (Member member: members) {
            System.out.println(member);
        }
    }

    public Book isSelectedBookExists(int bookId) {
        for (Book book: books) {
            if (book.getId() == bookId) {
                return book;
            }
        }

        return null;
    }

    public boolean isSelectedBookAvailable(int bookId) {
        Book selectedBook = isSelectedBookExists(bookId);
        if (selectedBook != null) {
            return selectedBook.getIsAvailable();
        }
        return false;
    }

    public void borrowBook(Member member) {
        showAvailableBooks();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the id of the book you want to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        if (bookId >= 1 && bookId < Book.nextBookId && isSelectedBookAvailable(bookId)) {
            Book selectedBook = isSelectedBookExists(bookId);

            member.borrowBook(selectedBook);

            selectedBook.setIsAvailable(false);

            borrowedBooks++;

            System.out.println("Member '" + member.getFullName() + "' borrowed the book '" + selectedBook.getTitle() + "'");
        }
        else {
            System.out.println("Book not exists or not available");
        }
    }
}