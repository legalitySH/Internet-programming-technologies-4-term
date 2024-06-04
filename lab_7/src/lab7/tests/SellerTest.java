package lab7.tests;

import lab7.Serializer;
import lab7.products.Book;
import lab7.store.Seller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SellerTest {
    private Seller seller;
    private Book book;

    public SellerTest(Book book) {
        this.book = book;
    }

    @Parameterized.Parameters
    public static Collection<Book> data() {
        Serializer serializer = new Serializer();
        ArrayList<Book> books = serializer.deserializeObject(".\\src\\lab7\\tests\\books.json");
        return books;
    }

    @Before
    public void setUp() {
        seller = new Seller();
    }

    @After
    public void tearDown() {
        seller = null;
    }

    @Test
    public void testSell() {
        seller.add(book);
        seller.sell(book);
        if (!seller.getEditionList().isEmpty()) {
            Book bookFromEditionList = (Book) seller.getEditionList().get(0);
            assertEquals(book.getCount() - 1,bookFromEditionList.getCount());
        }
    }
}