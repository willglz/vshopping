package org.vshopping.model;

import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.person.employee.EmployeeServices;
import org.vshopping.navigation.LogIn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        EmployeeServices eServices = new EmployeeServices();
        Scanner sc = new Scanner(System.in);
        if (eServices.verifyEmployee()){
            System.out.println("U gonna be the first user of the system");
            System.out.print("First name: ");
            String fn = sc.nextLine();
            System.out.print("Last name: ");
            String ln = sc.nextLine();
            System.out.print("Address: ");
            String ad = sc.nextLine();
            System.out.print("Email: ");
            String mail = sc.nextLine();
            System.out.print("Role: ");
            String rol = sc.nextLine();
            System.out.print("User: ");
            String user = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();
            Employee employee = new Employee(fn, ln, ad, mail, user, pass, rol);
            System.out.println(eServices.addEmployee(employee));
            logIn.exec();
        }else {
            logIn.exec();
        }
    }
}
