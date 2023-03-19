package org.vshopping.model.product;

import java.util.List;

public interface ProductDAO {
    void saveProduct(Product products);
    List<Product> getProducts();
    void deleteProduct(Product product);
    void editProduct(Product products);
}
