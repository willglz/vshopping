package org.vshopping.model.product.videogames;

import org.vshopping.model.order.Order;
import org.vshopping.model.order.OrderServices;
import org.vshopping.model.product.Product;

import java.util.List;

public class vGamesServices {
    private static final vGamesDAO GAMES_DAO = new vGamesDAO();
    private OrderServices oServices = new OrderServices();

    public String addGame(vGames vGames){
        GAMES_DAO.saveProduct(vGames);
        return "Game added successfully";
    }

    public String editGame(vGames vGames){
        GAMES_DAO.editProduct(vGames);
        return "Game edited successfully";
    }

    public String listAvailableGames(){
        StringBuilder sbGames = new StringBuilder("No games to show you");
        for (Product games : this.showGames()) {
            if (((vGames) games).getStock() > 0){
                sbGames.delete(0, 20);
                sbGames.append(games);
            }
        }
        return sbGames.toString();
    }

    public String listGames(){
        StringBuilder sbGames = new StringBuilder("No games to show you");
        for (Product games : this.showGames()) {
            sbGames.delete(0, 20);
            sbGames.append(games);
        }
        return sbGames.toString();
    }

    public List<Product> showGames(){
        return GAMES_DAO.getProducts();
    }

    public vGames findGameById(String id){
        vGames v = null;
        for (Product product : this.showGames()) {
            if (product != null && product.getId() == Integer.parseInt(id)){
                v = (vGames) product;
                break;
            }
        }
        return v;
    }

    public String deleteGame(vGames vGames){
        for (Order o: oServices.showOrders()){
            if (vGames.equals(o.getGames())){
                return "This game cannot be deleted because it is in active order.";
            }
        }
        GAMES_DAO.deleteProduct(vGames);
        return "Game deleted successfully";
    }

    public boolean verifyGames(){
        return this.showGames().isEmpty();
    }
}
