package org.vshopping.navigation;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.product.Product;
import org.vshopping.model.product.videogames.vGames;
import org.vshopping.model.product.videogames.vGamesServices;

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
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Platform: ");
                    String platform = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    vGames game = new vGames(title, price, platform, genre, stock);
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
                    if (gameServices.findGameById(idGamToS) != null){
                        System.out.println(gameServices.findGameById(idGamToS));
                    }
                    System.out.println("Game doesn't exist");
                    break;
                case "5":
                    System.out.println("Enter the game ID to modify");
                    int idGam = sc.nextInt();
                    for(Product p: gameServices.showGames()){
                        if (p != null && p.getId() == idGam){
                            sc.nextLine();
                            System.out.println(gameServices.findGameById(String.valueOf(idGam)));
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
                            p = new vGames(idGam ,title2m, price2m, platform2m, genre2m, stock2m);
                            System.out.println(gameServices.editGame((vGames) p));
                        }
                    }
                    break;
                case "6":
                    System.out.println("Enter the game ID to delete");
                    int idGamtoDelete = sc.nextInt();
                    for(Product p: gameServices.showGames()){
                        if (p != null && p.getId() == idGamtoDelete){
                            System.out.println(gameServices.deleteGame(p));
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }
        }
    }
}
