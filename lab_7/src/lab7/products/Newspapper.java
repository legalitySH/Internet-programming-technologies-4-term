package lab7.products;

import java.time.LocalDateTime;

public class Newspapper extends Edition {
    private final LocalDateTime issueDate;


    public Newspapper(String title, double price, Genre genre, int year) throws Exception {
        super(title, price, genre, year);
        this.issueDate = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Newspaper{" +
                "issueDate=" + issueDate +
                '}';
    }
}