package lab7.store;

import lab7.products.Book;
import lab7.products.Edition;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Bookstore implements Serializable {

    protected List<Edition> editionList = new ArrayList<>();






    public Bookstore(){}
    public List<Edition> getEditionList() {
        return editionList;
    }

    protected static class YearComparator implements Comparator<Book>
    {
        @Override
        public int compare(Book book1, Book book2) {
            return Integer.compare(book1.getPublishingYear(), book2.getPublishingYear());
        }
    }

    public double GetOverPrice()
    {
        double overPrice = 0;
        for(var item : editionList)
        {
            overPrice+=item.getPrice();
        }
        return overPrice;
    }

    public <T extends Edition> List<T> filterByType(Class<T> type) {
        return editionList.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .toList();
    }

    public void add(Edition edition)
    {
        editionList.add(edition);
    }


    public Edition getEditionByTitle(String title) throws Exception{
        Edition found = null;
        for (Edition item : editionList) {
            if (item.getTitle().equals(title)) {
                found = item;
                break;
            }
        }

        if (found == null) {
            throw new Exception("Edition with this title not found");
        }
        return found;

    }



    public List<Book> SortBooks()
    {
        List<Book> bookList = filterByType(Book.class);
        YearComparator yearComparator = new YearComparator();
        bookList.sort(yearComparator);
        return bookList;
    }

    public void Remove(Edition edition)
    {
        editionList.remove(edition);
    }





}