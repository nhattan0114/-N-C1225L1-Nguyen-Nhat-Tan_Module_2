package javacollection.compare;

import javacollection.entity.Product;

import java.util.Comparator;

public class compareProductID implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getProductID().compareTo(o2.getProductID());
    }
}
