package org.vshopping.model;

import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.person.employee.EmployeeServices;
import org.vshopping.navigation.LogIn;
import org.vshopping.utils.validators.StringValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        EmployeeServices eServices = new EmployeeServices();
        Scanner sc = new Scanner(System.in);
        if (eServices.verifyEmployee()){
            System.out.println("U gonna be the first user of the system");
            while (true){
                System.out.print("First name: ");
                String fn = sc.nextLine();
                if (StringValidator.isBlankValidator(fn) ||
                        StringValidator.isEmptyValidator(fn) ||
                        StringValidator.longValidator(fn)){
                    System.out.println("First name is blank, empty or short long");
                    continue;
                }
                System.out.print("Last name: ");
                String ln = sc.nextLine();
                if (StringValidator.isBlankValidator(ln) ||
                        StringValidator.isEmptyValidator(ln) ||
                        StringValidator.longValidator(ln)){
                    System.out.println("Last name is blank, empty or short long");
                    continue;
                }
                System.out.print("Address: ");
                String ad = sc.nextLine();
                if (StringValidator.isBlankValidator(ad) ||
                        StringValidator.isEmptyValidator(ad) ||
                        StringValidator.longValidator(ad)){
                    System.out.println("Address is blank, empty or short long");
                    continue;
                }
                System.out.print("Email: ");
                String mail = sc.nextLine();
                if (StringValidator.isBlankValidator(mail) ||
                        StringValidator.isEmptyValidator(mail) ||
                        StringValidator.longValidator(mail)){
                    System.out.println("E-mail is blank, empty or short long");
                    continue;
                }
                System.out.print("Role: ");
                String rol = sc.nextLine();
                if (StringValidator.isBlankValidator(rol) ||
                        StringValidator.isEmptyValidator(rol) ||
                        StringValidator.longValidator(rol)){
                    System.out.println("Rol is blank, empty or short long");
                    continue;
                }
                System.out.print("User: ");
                String user = sc.nextLine();
                if (StringValidator.isBlankValidator(user) ||
                        StringValidator.isEmptyValidator(user) ||
                        StringValidator.longValidator(user)){
                    System.out.println("User is blank, empty or short long");
                    continue;
                }
                System.out.print("Password: ");
                String pass = sc.nextLine();
                if (StringValidator.isBlankValidator(pass) ||
                        StringValidator.isEmptyValidator(pass) ||
                        StringValidator.longValidator(pass)){
                    System.out.println("Password is blank, empty or short long");
                    continue;
                }
                Employee employee = new Employee(fn, ln, ad, mail, user, pass, rol);
                System.out.println(eServices.addEmployee(employee));
                logIn.exec();
                break;
            }
        }
    }
}
