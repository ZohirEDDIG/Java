import system.LibraryManagement;
import models.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LibraryManagement system = new LibraryManagement();

        Book theLordOfTheRings = new Book("The Lord of the Rings",  "John Ronald Reuel Tolkien");
        Book donQuixote = new Book("Don Quixote", "Miguel de Cervantes");
        Book prideAndPrejudice = new Book("Pride and Prejudice", "Jane Austen");

        system.addBook(theLordOfTheRings);
        system.addBook(donQuixote);
        system.addBook(prideAndPrejudice);

//       system.showAllBooks();

        Member zohirEDDIG = new Member("Zohir EDDIG");
        Member anassEDDIG = new Member("Anass EDDIG");

        system.addMember(zohirEDDIG);
        system.addMember(anassEDDIG);

//       system.showMembers();

//       system.borrowBook();

        system.borrowBook(zohirEDDIG);
    }
}