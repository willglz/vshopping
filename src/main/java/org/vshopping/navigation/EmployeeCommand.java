package org.vshopping.navigation;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.employee.Employee;
import org.vshopping.model.person.employee.EmployeeServices;

import java.util.Scanner;

public class EmployeeCommand implements Command{
    @Override
    public void exec() {
        EmployeeServices eServices = new EmployeeServices();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== EMPLOYEE ===");
            System.out.println("1 - Add Employee");
            System.out.println("2 - View all Employees");
            System.out.println("3 - Search Employee");
            System.out.println("4 - Edit Employee");
            System.out.println("5 - Delete Employee");
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
                    System.out.print("Role: ");
                    String rol = sc.nextLine();
                    System.out.print("User: ");
                    String user = sc.nextLine();
                    System.out.print("Password: ");
                    String pass = sc.nextLine();
                    Employee employee = new Employee(fn, ln, ad, mail, user, pass, rol);
                    System.out.println(eServices.addEmployee(employee));
                    break;
                case "2":
                    System.out.println(eServices.listCustomer());
                    break;
                case "3":
                    System.out.println("Enter the employee ID to search");
                    String idEmpToS = sc.nextLine();
                    if (eServices.findEmployeeById(idEmpToS) != null){
                        System.out.println(eServices.findEmployeeById(idEmpToS));
                    }
                    System.out.println("Employee doesn't exist");
                    break;
                case "4":
                    System.out.println("Enter the employee ID to modify");
                    int idEmp = sc.nextInt();
                    for(Person p: eServices.showEmployees()){
                        if (p != null && p.getId() == idEmp){
                            sc.nextLine();
                            System.out.println(eServices.findEmployeeById(String.valueOf(idEmp)));
                            System.out.println("Employee found!!\nEnter de new data for this employee");
                            System.out.print("First name: ");
                            String fn2m = sc.nextLine();
                            System.out.print("Last name: ");
                            String ln2m = sc.nextLine();
                            System.out.print("Address: ");
                            String ad2m = sc.nextLine();
                            System.out.print("Email: ");
                            String mail2m = sc.nextLine();
                            System.out.print("Role: ");
                            String rol2m = sc.nextLine();
                            System.out.print("User: ");
                            String user2m = sc.nextLine();
                            System.out.print("Password: ");
                            String pass2m = sc.nextLine();
                            p = new Employee(idEmp ,fn2m, ln2m, ad2m, mail2m, user2m, pass2m, rol2m);
                            System.out.println(eServices.editEmployee((Employee) p));
                        }
                    }
                    break;
                case "5":
                    System.out.println("Enter the employee ID to delete");
                    int idEmptoDelete = sc.nextInt();
                    for(Person p: eServices.showEmployees()){
                        if (p != null && p.getId() == idEmptoDelete){
                            System.out.println(eServices.deleteEmployee(p));
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
