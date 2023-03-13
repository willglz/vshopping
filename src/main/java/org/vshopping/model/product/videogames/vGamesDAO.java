package org.vshopping.model.product.videogames;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.person.employee.EmployeeDB;
import org.vshopping.model.product.Product;
import org.vshopping.model.product.ProductDAO;

import java.util.List;

public class vGamesDAO implements ProductDAO {
    @Override
    public void saveProduct(Product products) {
        vGamesDB.getDataSource().add(products);
    }

    @Override
    public Product searchProductById(int id) {
        vGames v = null;
        for (Product product : vGamesDB.getDataSource()) {
            if (product != null && product.getId() == id){
                v = (vGames) product;
                break;
            }
        }
        return v;
    }

    @Override
    public List<Product> getProducts() {
        return vGamesDB.getDataSource();
    }

    @Override
    public void deleteProduct(int id) {
        vGamesDB.getDataSource().remove(this.searchProductById(id));
    }

    @Override
    public void editProduct(Product products) {
        vGames v = (vGames) this.searchProductById(products.getId());
        v.setName(products.getName());
        v.setPrice(products.getPrice());
        v.setPlatform(((vGames) products).getPlatform());
        v.setGenre(((vGames) products).getGenre());
    }
}
