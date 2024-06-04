package by.shymko.second.store;

import by.shymko.second.products.Book;
import by.shymko.second.products.Edition;
import by.shymko.second.products.Magazine;
import by.shymko.second.shopexception.EditionFindException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Seller extends Bookstore {

    public Seller(Logger logger) throws IOException {
        super(logger);

    }

    public void sell(Edition edition)
    {
        int index = editionList.indexOf(edition);
        Edition soldProduct = (Edition) editionList.get(index);
        editionList.remove(soldProduct);
        int count = soldProduct.getCount();
        if(soldProduct.getCount() - 1 > 0)
        {
            soldProduct.setCount(soldProduct.getCount()-1);
            editionList.add(soldProduct);
        }



    }






}
