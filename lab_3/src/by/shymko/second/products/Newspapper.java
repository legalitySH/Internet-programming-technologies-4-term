package by.shymko.second.products;

import by.shymko.second.shopexception.EmptyNameException;
import by.shymko.second.shopexception.PriceFormatException;
import by.shymko.second.shopexception.YearFormatException;

import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

public class Newspapper extends Edition {
    private Logger logger;
    private final LocalDateTime issueDate;


    public Newspapper(String title, double price, Genre genre, int year,Logger logger) throws EmptyNameException, YearFormatException, PriceFormatException, IOException {
        super(title, price, genre, year,logger);
        this.issueDate = LocalDateTime.now();
        logger.info("Newspaper created - Title: " + title + ", Issue Date: " + issueDate);
    }


    @Override
    public String toString() {
        return "Newspaper{" +
                "issueDate=" + issueDate +
                '}';
    }
}
