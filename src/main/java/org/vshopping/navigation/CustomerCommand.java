package org.vshopping.navigation;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.customer.Customer;
import org.vshopping.model.person.customer.CustomerServices;

import java.util.Scanner;

public class CustomerCommand implements Command{
    @Override
    public void exec() {
        CustomerServices cServices = new CustomerServices();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== CUSTOMERS ===");
            System.out.println("1 - Add Customer");
            System.out.println("2 - View all Customer");
            System.out.println("3 - Search Customer");
            System.out.println("4 - Edit Customer");
            System.out.println("5 - Delete Customer");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");
            String opt = sc.nextLine();

            if ("0".equals(opt)) {
                break;
            }

            switch (opt) {
                case "1":
                    System.out.print("First name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last name: ");
                    String ln = sc.nextLine();
                    System.out.print("Address: ");
                    String ad = sc.nextLine();
                    System.out.print("Email: ");
                    String mail = sc.nextLine();
                    Customer customer = new Customer(fn, ln, ad, mail);
                    System.out.println(cServices.addCustomer(customer));
                    break;
                case "2":
                    for (Person showCustomer : cServices.showCustomer()) {
                        System.out.println(showCustomer);
                    }
                    break;
                case "3":
                    System.out.println("Enter the employee ID to search");
                    int idCusToS = sc.nextInt();
                    if (cServices.findCustomerById(idCusToS) != null){
                        System.out.println(cServices.findCustomerById(idCusToS));
                    }
                    System.out.println("Customer doesn't exist");
                    break;
                case "4":
                    System.out.println("Enter the Customer ID to modify");
                    int idCus = sc.nextInt();
                    for(Person p: cServices.showCustomer()){
                        if (p != null && p.getId() == idCus){
                            sc.nextLine();
                            System.out.println(cServices.findCustomerById(idCus));
                            System.out.println("Customer found!!\nEnter de new data for this customer");
                            System.out.print("First name: ");
                            String fn2m = sc.nextLine();
                            System.out.print("Last name: ");
                            String ln2m = sc.nextLine();
                            System.out.print("Address: ");
                            String ad2m = sc.nextLine();
                            System.out.print("Email: ");
                            String mail2m = sc.nextLine();
                            p = new Customer(idCus ,fn2m, ln2m, ad2m, mail2m);
                            System.out.println(cServices.editCustomer((Customer) p));
                        }
                    }
                    break;
                case "5":
                    System.out.println("Enter the Customer ID to delete");
                    int idCustoDelete = sc.nextInt();
                    for(Person p: cServices.showCustomer()){
                        if (p != null && p.getId() == idCustoDelete){
                            System.out.println(cServices.deleteCustomer(idCustoDelete));
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
