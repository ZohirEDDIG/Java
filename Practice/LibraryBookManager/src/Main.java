import model.Book;
import model.BookGenre;

import service.SimpleBookManager;

public class Main {
    public static void main(String[] args) {
        SimpleBookManager manager = new SimpleBookManager();

        Book b1 = new Book("Brave New World", "Aldous Huxley", BookGenre.FICTION, 1932);
        Book b2 = new Book("Pride and Prejudice", "Jane Austen", BookGenre.FICTION, 1813);
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee", BookGenre.FICTION, 1960);
        Book b4 = new Book("In Cold Blood", "Truman Capote", BookGenre.NON_FICTION, 1966);
        Book b5 = new Book("Just Mercy", "Bryan Stevenson", BookGenre.NON_FICTION, 2014);
        Book b6 = new Book("The Immortal Life of Henrietta Lacks", " Rebecca Skloot", BookGenre.NON_FICTION, 2010);

        manager.addBook(b1);
        manager.addBook(b2);
        manager.addBook(b3);
        manager.addBook(b4);
        manager.addBook(b5);
        manager.addBook(b6);
    }
}
