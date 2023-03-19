package org.vshopping.navigation;

import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.person.employee.EmployeeServices;

import java.util.Scanner;

public class LogIn implements Command{

    @Override
    public void exec() {
        EmployeeServices eServices = new EmployeeServices();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("LOGIN MENU");
            System.out.println("1 - Log In");
            System.out.println("0 - Exit");
            String opt = sc.nextLine();
            if (opt.equals("0")){
                break;
            }
            switch (opt){
                case "1":
                    System.out.println("Username: ");
                    String user = sc.nextLine();
                    System.out.println("Password: ");
                    String pass = sc.nextLine();
                    if (eServices.logInEmployee(user, pass)){
                        Employee.setUserInLog(eServices.findEmployeeByUser(user).getUser());
                        Employee.setIdInLog(eServices.findEmployeeByUser(user).getId());
                        MainCommand main = new MainCommand();
                        main.exec();
                    }else {
                        System.out.println("wrong user or pass");
                    }
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }

        }
    }
}
