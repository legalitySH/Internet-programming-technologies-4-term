package lab7.main;

import lab7.Serializer;
import lab7.products.Book;
import lab7.store.Bookstore;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book_1 = new Book();
        Book book_2 = new Book();
        Book book_3 = new Book();

        book_1.setCount(1);
        book_2.setCount(2);
        book_1.setCount(0);

        List<Book> books = new ArrayList<>();

        books.add(book_1);
        books.add(book_2);
        books.add(book_3);

        Serializer serializer = new Serializer();

        serializer.serializeObject(books, ".\\src\\lab7\\tests\\books.json");

    }
}