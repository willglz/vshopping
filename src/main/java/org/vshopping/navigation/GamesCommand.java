package org.vshopping.navigation;

import org.vshopping.model.product.videogames.vGamesServices;

public class GamesCommand implements Command{
    @Override
    public void exec() {
        vGamesServices gameServices = new vGamesServices();
    }
}
