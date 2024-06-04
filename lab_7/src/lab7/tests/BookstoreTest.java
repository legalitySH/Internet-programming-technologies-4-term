package lab7.tests;

import lab7.products.Book;
import lab7.products.Edition;
import lab7.products.Genre;
import lab7.products.Magazine;
import lab7.store.Bookstore;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class BookstoreTest {

    public Bookstore bookstore;

    @Before
    public void setUp() {
        bookstore = new Bookstore();
    }

    @After
    public void afterEach() {
        bookstore = null;
    }

    @Test
    public void TestOverPrice() {
        Book firstBook = new Book();
        Book secondBook = new Book();

        firstBook.setPrice(10);
        secondBook.setPrice(15);

        bookstore.add(firstBook);
        bookstore.add(secondBook);
        assertEquals(25, bookstore.GetOverPrice(),0);
    }
    @Test
    public void testFilterByType() throws Exception {
        Magazine first = new Magazine();
        Book second = new Book();
        second.setTitle("Book");
        first.setTitle("Magazine");

        bookstore.add(first);
        bookstore.add(second);

        List<Book> books = bookstore.filterByType(Book.class);

        assertEquals(1, books.size());
        assertEquals("Book", books.get(0).getTitle());
    }

    @Test
    public void testGetEditionByTitle() throws Exception {
        Magazine first = new Magazine();
        Book second = new Book();
        second.setTitle("Book");
        first.setTitle("Magazine");

        bookstore.add(first);
        bookstore.add(second);

        try {
            assertEquals(first, bookstore.getEditionByTitle("Magazine"));
        } catch (Exception ex) {
            assertEquals(first, null);
        }
    }
    @Ignore
    @Test
    public void testIgnoredMethod() {
    }
}