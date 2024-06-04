package lab7.store;

import lab7.products.Edition;



public class Seller extends Bookstore {

    public Seller() {
    }

    public void sell(Edition edition) {
        int index = editionList.indexOf(edition);
        Edition soldProduct = (Edition) editionList.get(index);
        editionList.remove(soldProduct);
        int count = soldProduct.getCount();
        if (soldProduct.getCount() - 1 > 0) {
            soldProduct.setCount(soldProduct.getCount() - 1);
            editionList.add(soldProduct);
        }
    }
}
