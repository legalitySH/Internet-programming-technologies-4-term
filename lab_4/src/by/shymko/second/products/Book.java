package by.shymko.second.products;

import by.shymko.second.shopexception.EmptyNameException;
import by.shymko.second.shopexception.NullPageException;
import by.shymko.second.shopexception.PriceFormatException;
import by.shymko.second.shopexception.YearFormatException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;


public class Book extends Edition implements Serializable
{


    private String author;


    private int countOfPages;

    private Logger logger;
    public Book(String title, double price, Genre genre, int year, Logger logger, String author, int countOfPages) throws
            NullPageException, EmptyNameException, YearFormatException, PriceFormatException, IOException {
        super(title, price, genre,year,logger);
        this.author = author;
        if(countOfPages < 0) {
            throw new NullPageException("Try to create book " + title + "with null pages",logger);
        }
        this.countOfPages = countOfPages;
        logger.info("Book created - Title: " + title + ", Author: " + author + ", Pages: " + countOfPages);

    }
    public Book()
    {

    }


    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCountOfPages() { return countOfPages; }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", price=" + getPrice() +
                ", genre=" + getGenre() +
                ", author='" + author + '\'' +
                ", countOfPages=" + countOfPages +
                '}';
    }
}