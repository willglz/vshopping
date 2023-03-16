package org.vshopping.model.product.videogames;

import org.vshopping.model.product.Product;
import org.vshopping.model.product.ProductDAO;

import java.util.List;

public class vGamesDAO implements ProductDAO {
    @Override
    public void saveProduct(Product products) {
        vGamesDB.getDataSource().add(products);
    }

    @Override
    public List<Product> getProducts() {
        return vGamesDB.getDataSource();
    }

    @Override
    public void deleteProduct(Product product) {
        vGamesDB.getDataSource().remove(product);
    }

    @Override
    public void editProduct(Product products) {
        vGamesServices temp = new vGamesServices();
        vGames v = temp.findGameById(String.valueOf(products.getId()));
        v.setName(products.getName());
        v.setPrice(products.getPrice());
        v.setPlatform(((vGames) products).getPlatform());
        v.setGenre(((vGames) products).getGenre());
        v.setStock(((vGames) products).getStock());
    }
}
