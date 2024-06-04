package lab7.products;

import java.io.Serializable;

public class Book extends Edition implements Serializable
{
    private String author;
    private int countOfPages;

    public Book(String title, double price, Genre genre, int year, String author, int countOfPages) throws Exception{
        super(title, price, genre,year);
        this.author = author;
        if(countOfPages < 0) {
            throw new Exception("Try to create book " + title + "with null pages");
        }
        this.countOfPages = countOfPages;

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