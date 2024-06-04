package by.shymko.second.products;

import by.shymko.second.shopexception.EmptyNameException;
import by.shymko.second.shopexception.PriceFormatException;
import by.shymko.second.shopexception.YearFormatException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

public abstract class Edition {

    private String title;
    private double price;
    private Genre genre;
    private int count;


    private Logger logger;



    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    private int publishingYear;



    public Edition(String title, double price , Genre genre, int year, Logger logger) throws EmptyNameException, YearFormatException, PriceFormatException, IOException {
        if("" == title)
        {
            throw new EmptyNameException("Try to create edition with empty name",logger);
        }

        if(year < 0 || LocalDate.now().getYear() < year)
        {
            throw new YearFormatException("Invalid year format",logger);
        }
        if(price < 0)
        {
            throw new PriceFormatException("Invalid price format",logger);
        }

        this.title = title;
        this.price = price;
        this.genre = genre;
        this.publishingYear = year;
        this.logger = logger;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Logger getLogger() {
        return logger;
    }


    @Override
    public String toString() {
        return "Edition{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", genre=" + genre +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edition edition)) return false;
        return Double.compare(price, edition.price) == 0 && publishingYear == edition.publishingYear && Objects.equals(title, edition.title) && genre == edition.genre;
    }


}

