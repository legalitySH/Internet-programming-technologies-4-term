package lab7.products;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Edition implements Serializable {

    private String title;
    private double price;
    private Genre genre;
    private int count;
    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    private int publishingYear;


    public Edition()
    {

    }

    public Edition(String title, double price , Genre genre, int year) throws  Exception {
        if("" == title)
        {
            throw new Exception("Try to create edition with empty name");
        }

        if(year < 0 || LocalDate.now().getYear() < year)
        {
            throw new Exception("Invalid year format");
        }
        if(price < 0)
        {
            throw new Exception("Invalid price format");
        }

        this.title = title;
        this.price = price;
        this.genre = genre;
        this.publishingYear = year;
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