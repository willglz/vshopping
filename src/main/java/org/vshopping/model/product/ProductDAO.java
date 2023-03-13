package org.vshopping.model.product;

import java.util.List;

public interface ProductDAO {
    void saveProduct(Product products);
    Product searchProductById(int id);
    List<Product> getProducts();
    void deleteProduct(int id);
    void editProduct(Product products);
}
