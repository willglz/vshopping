package org.vshopping.model.product.videogames;

import org.vshopping.model.person.Person;
import org.vshopping.model.product.Product;

import java.util.List;

public class vGamesServices {
    private static final vGamesDAO GAMES_DAO = new vGamesDAO();

    public String addGame(vGames vGames){
        GAMES_DAO.saveProduct(vGames);
        return "Game added successfully";
    }

    public String editGame(vGames vGames){
        GAMES_DAO.editProduct(vGames);
        return "Game edited successfully";
    }

    public String listGames(){
        StringBuilder sbGames = new StringBuilder();
        for (Product Games : this.showGames()) {
            sbGames.append(Games.toString());
        }
        return sbGames.toString();
    }

    public List<Product> showGames(){
        return GAMES_DAO.getProducts();
    }

    public vGames findGameById(int id){
        return (vGames) GAMES_DAO.searchProductById(id);
    }

    public String deleteGame(int id){
        GAMES_DAO.deleteProduct(id);
        return "Game deleted successfully";
    }
}
