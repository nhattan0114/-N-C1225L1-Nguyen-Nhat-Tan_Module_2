package javacollection.compare;

import javacollection.entity.Product;

import java.util.Comparator;

public class compareProductPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(),o2.getPrice());
    }
}
