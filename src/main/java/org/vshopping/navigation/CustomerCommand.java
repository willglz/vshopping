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
                    System.out.println(cServices.listCustomer());
                    break;
                case "3":
                    System.out.println("Enter the employee ID to search");
                    String idCusToS = sc.nextLine();
                    try{
                        if (cServices.findCustomerById(idCusToS) != null){
                            System.out.println(cServices.findCustomerById(idCusToS));
                        }
                    }catch (NumberFormatException e){System.out.println("Wrong ID");}
                    System.out.println("Customer doesn't exist");
                    break;
                case "4":
                    System.out.println("Enter the Customer ID to modify");
                    String idCus = sc.nextLine();
                    for(Person p: cServices.getCustomers()){
                        try {
                            if (p != null && p.getId() == Integer.parseInt(idCus)){
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
                                p = new Customer(Integer.parseInt(idCus) ,fn2m, ln2m, ad2m, mail2m);
                                System.out.println(cServices.editCustomer((Customer) p));
                            }
                        }catch (NumberFormatException e){System.out.println("Wrong ID");}
                    }
                    System.out.println("Customer doesn't exist");
                    break;
                case "5":
                    System.out.println("Enter the Customer ID to delete");
                    String idCusToDelete = sc.nextLine();
                    for(Person p: cServices.getCustomers()){
                        try{
                            if (p != null && p.getId() == Integer.parseInt(idCusToDelete)){
                                System.out.println(cServices.deleteCustomer((Customer) p));
                                break;
                            }
                        }catch (NumberFormatException e){
                            System.out.println("Wrong ID");
                        }
                    }
                    System.out.println("Customer doesn't exist");
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }
        }
    }
}
