package javacollection.service;

import javacollection.entity.Product;

import java.util.List;

public interface IProductService {
    boolean addProduct(Product product);
    List<Product> getProductList();
    boolean deleteProduct(String productID);
    boolean updateProduct(String id,Product Product);
    List<Product> searchProduct(String name);
    boolean sortProductPriceAsc();
    boolean sortProductPriceDesc();
    boolean sortProductID();
}
