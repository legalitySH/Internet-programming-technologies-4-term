package by.shymko.second.products;

import by.shymko.second.shopexception.EmptyNameException;
import by.shymko.second.shopexception.IssueFormatException;
import by.shymko.second.shopexception.PriceFormatException;
import by.shymko.second.shopexception.YearFormatException;

import java.io.IOException;
import org.apache.log4j.Logger;
public class Magazine extends Edition{


    private String issueNumber;

    private Logger logger;
    public String getIssueNumber() {
        return issueNumber;
    }

    public Magazine(String title, double price, Genre genre, int year,Logger logger,String issueNumber)
            throws EmptyNameException, YearFormatException, PriceFormatException, IssueFormatException, IOException {
        super(title, price, genre, year,logger);
        if (issueNumber == "") {
            throw new IssueFormatException("Invalid issue format",logger);
        }
        this.issueNumber = issueNumber;
        logger.info("Newspaper created - Title: " + title + ", Issue Date: " + issueNumber);


    }


    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber='" + issueNumber + '\'' +
                '}';
    }
}

