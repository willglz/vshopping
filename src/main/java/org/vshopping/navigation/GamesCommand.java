package org.vshopping.navigation;

import org.vshopping.model.product.Product;
import org.vshopping.model.product.videogames.vGames;
import org.vshopping.model.product.videogames.vGamesServices;
import org.vshopping.utils.validators.NumberValidator;
import org.vshopping.utils.validators.StringValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GamesCommand implements Command{
    @Override
    public void exec() {
        vGamesServices gameServices = new vGamesServices();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== GAMES ===");
            System.out.println("1 - Add Game");
            System.out.println("2 - View all Games");
            System.out.println("3 - View Available Games");
            System.out.println("4 - Search Game");
            System.out.println("5 - Edit Game");
            System.out.println("6 - Delete Game");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");
            String opt = sc.nextLine();

            if ("0".equals(opt)) {
                break;
            }

            switch (opt) {
                case "1":
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    if (StringValidator.isBlankValidator(title) ||
                            StringValidator.isEmptyValidator(title) ||
                            StringValidator.longValidator(title)){
                        System.out.println("Title is blank, empty or short long");
                        break;
                    }
                    System.out.print("Price: ");
                    String price = sc.nextLine();
                    if (!NumberValidator.greaterThanZero(Double.parseDouble(price)) ||
                            !NumberValidator.priceChecker(Double.parseDouble(price))){
                        System.out.println("Price must be greater than zero and $10");
                        break;
                    }
                    System.out.print("Platform: ");
                    String platform = sc.nextLine();
                    if (StringValidator.isBlankValidator(platform) ||
                            StringValidator.isEmptyValidator(platform) ||
                            StringValidator.longValidator(platform)){
                        System.out.println("Platform is blank, empty or short long");
                        break;
                    }
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    if (StringValidator.isBlankValidator(genre) ||
                            StringValidator.isEmptyValidator(genre) ||
                            StringValidator.longValidator(genre)){
                        System.out.println("Genre is blank, empty or short long");
                        break;
                    }
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    if (!NumberValidator.greaterThanZero(stock)){
                        System.out.println("Stock must be greater than zero and $10");
                        break;
                    }
                    vGames game = new vGames(title, Double.parseDouble(price), platform, genre, stock);
                    System.out.println(gameServices.addGame(game));
                    break;
                case "2":
                    System.out.println(gameServices.listGames());
                    break;
                case "3":
                    System.out.println(gameServices.listAvailableGames());
                    break;
                case "4":
                    System.out.println("Enter the game ID to search");
                    String idGamToS = sc.nextLine();
                    try{
                        if (gameServices.findGameById(idGamToS) != null){
                            System.out.println(gameServices.findGameById(idGamToS));
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Wrong ID");
                    }
                    System.out.println("Game doesn't exist");
                    break;
                case "5":
                    System.out.println("Enter the game ID to modify");
                    String idGam = sc.nextLine();
                    for(Product p: gameServices.showGames()){
                        try{
                            if (p != null && p.getId() == Integer.parseInt(idGam)){
                                sc.nextLine();
                                System.out.println(gameServices.findGameById(idGam));
                                System.out.println("Game found!!\nEnter de new data for this employee");
                                System.out.print("First name: ");
                                System.out.print("Title: ");
                                String title2m = sc.nextLine();
                                System.out.print("Price: ");
                                double price2m = sc.nextDouble();
                                System.out.print("Platform: ");
                                String platform2m = sc.nextLine();
                                System.out.print("Genre: ");
                                String genre2m = sc.nextLine();
                                System.out.print("Stock: ");
                                int stock2m = sc.nextInt();
                                p = new vGames(Integer.parseInt(idGam) ,title2m, price2m, platform2m,
                                        genre2m, stock2m);
                                System.out.println(gameServices.editGame((vGames) p));
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Wrong ID");
                        }
                    }
                    System.out.println("Game doesn't exist");
                    break;
                case "6":
                    System.out.println("Enter the game ID to delete");
                    String idGamtoDelete = sc.nextLine();
                    for(Product p: gameServices.showGames()){
                        try {
                            if (p != null && p.getId() == Integer.parseInt(idGamtoDelete)){
                                System.out.println(gameServices.deleteGame((vGames) p));
                                break;
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Wrong ID");
                        }
                    }
                    System.out.println("Game doesn't exist");
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }
        }
    }
}
