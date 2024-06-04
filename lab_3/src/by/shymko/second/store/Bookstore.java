package by.shymko.second.store;
import by.shymko.second.products.Book;
import by.shymko.second.products.Edition;
import by.shymko.second.products.Magazine;
import by.shymko.second.products.Newspapper;
import by.shymko.second.shopexception.EditionFindException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.log4j.Logger;

public class Bookstore {

    protected List<Edition> editionList = new ArrayList<>();

    private Logger logger;
    public Bookstore(Logger logger) throws IOException {
        this.logger = logger;
    }

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
        logger.debug("Get over price operation");
        double overPrice = 0;
        for(var item : editionList)
        {
            overPrice+=item.getPrice();
        }
        logger.info("Calculate store overprice");

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
        logger.info("Adding new element in store");

    }


    public Edition getEditionByTitle(String title) throws EditionFindException, IOException {
        Edition found = null;
        for (Edition item : editionList) {
            if (item.getTitle().equals(title)) {
                found = item;
                break;
            }
        }

        if (found == null) {
            throw new EditionFindException("Edition with this title not found",logger);
        }
        return found;

    }



    public List<Book> SortBooks()
    {
        List<Book> bookList = filterByType(Book.class);
        YearComparator yearComparator = new YearComparator();
        bookList.sort(yearComparator);
        logger.info("Sort books operation");
        return bookList;
    }

    public void Remove(Edition edition)
    {
        logger.debug("Removed object " + edition.getTitle());
        editionList.remove(edition);
        logger.info("Remove "  + edition);
    }





}
