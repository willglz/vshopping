package org.vshopping.navigation;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.customer.Customer;
import org.vshopping.model.person.customer.CustomerServices;
import org.vshopping.utils.validators.StringValidator;

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
                    if (StringValidator.isBlankValidator(fn) ||
                            StringValidator.isEmptyValidator(fn) ||
                            StringValidator.longValidator(fn)){
                        System.out.println("First name is blank, empty or short long");
                        break;
                    }
                    System.out.print("Last name: ");
                    String ln = sc.nextLine();
                    if (StringValidator.isBlankValidator(ln) ||
                            StringValidator.isEmptyValidator(ln) ||
                            StringValidator.longValidator(ln)){
                        System.out.println("Last name is blank, empty or short long");
                        break;
                    }
                    System.out.print("Address: ");
                    String ad = sc.nextLine();
                    if (StringValidator.isBlankValidator(ad) ||
                            StringValidator.isEmptyValidator(ad) ||
                            StringValidator.longValidator(ad)){
                        System.out.println("Address is blank, empty or short long");
                        break;
                    }
                    System.out.print("Email: ");
                    String mail = sc.nextLine();
                    if (StringValidator.isBlankValidator(mail) ||
                            StringValidator.isEmptyValidator(mail) ||
                            StringValidator.longValidator(mail)){
                        System.out.println("E-mail is blank, empty or short long");
                        break;
                    }
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
                                if (StringValidator.isBlankValidator(fn2m) ||
                                        StringValidator.isEmptyValidator(fn2m) ||
                                        StringValidator.longValidator(fn2m)){
                                    System.out.println("First name is blank, empty or short long");
                                    break;
                                }
                                System.out.print("Last name: ");
                                String ln2m = sc.nextLine();
                                if (StringValidator.isBlankValidator(ln2m) ||
                                        StringValidator.isEmptyValidator(ln2m) ||
                                        StringValidator.longValidator(ln2m)){
                                    System.out.println("Last name is blank, empty or short long");
                                    break;
                                }
                                System.out.print("Address: ");
                                String ad2m = sc.nextLine();
                                if (StringValidator.isBlankValidator(ad2m) ||
                                        StringValidator.isEmptyValidator(ad2m) ||
                                        StringValidator.longValidator(ad2m)){
                                    System.out.println("Address is blank, empty or short long");
                                    break;
                                }
                                System.out.print("Email: ");
                                String mail2m = sc.nextLine();
                                if (StringValidator.isBlankValidator(mail2m) ||
                                        StringValidator.isEmptyValidator(mail2m) ||
                                        StringValidator.longValidator(mail2m)){
                                    System.out.println("E-mail is blank, empty or short long");
                                    break;
                                }
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
