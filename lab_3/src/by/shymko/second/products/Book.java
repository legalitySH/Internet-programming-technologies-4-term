package by.shymko.second.products;

import by.shymko.second.shopexception.EmptyNameException;
import by.shymko.second.shopexception.NullPageException;
import by.shymko.second.shopexception.PriceFormatException;
import by.shymko.second.shopexception.YearFormatException;
import org.apache.log4j.Logger;

import java.io.IOException;


public class Book extends Edition
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


    public String getAuthor() {
        return author;
    }

    public int getCountOfPages() { return countOfPages; }


    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", countOfPages=" + countOfPages +
                '}';
    }
}