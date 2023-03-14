package org.vshopping.navigation;

import org.vshopping.model.order.OrderServices;
import org.vshopping.model.person.Person;
import org.vshopping.model.person.customer.CustomerServices;
import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.product.videogames.vGamesServices;

import java.util.Scanner;

public class OrderCommand implements Command{
    @Override
    public void exec() {
        OrderServices oServices = new OrderServices();
        CustomerServices cServices = new CustomerServices();
        vGamesServices vServices = new vGamesServices();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== ORDER ===");
            System.out.println("1 - Add Order");
            System.out.println("2 - View all Orders");
            System.out.println("3 - Search Order");
            System.out.println("4 - Edit Order");
            System.out.println("5 - Delete Order");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");
            String opt = sc.nextLine();

            if ("0".equals(opt)) {
                break;
            }

            switch (opt) {
                case "1":
                    System.out.println(cServices.listCustomer());
                    System.out.println("Enter the Customer ID: ");
                    int idC = sc.nextInt();
                    System.out.println(vServices.listGames());
                    System.out.print("Enter the Game ID: ");
                    int idG = sc.nextInt();
                    System.out.print("Last name: ");
                    String ln = sc.nextLine();
                    System.out.print("Address: ");
                    String ad = sc.nextLine();
                    System.out.print("Email: ");
                    String mail = sc.nextLine();
                    System.out.print("Role: ");
                    String rol = sc.nextLine();
                    System.out.print("Base Salary: ");
                    double sal = sc.nextDouble();
                    break;
                case "2":
                    break;
                case "3":
                    System.out.println("Enter the employee ID to search");
                    int idEmpToS = sc.nextInt();
                    System.out.println("Employee doesn't exist");
                    break;
                case "4":
                    System.out.println("Enter the employee ID to modify");
                    int idEmp = sc.nextInt();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
