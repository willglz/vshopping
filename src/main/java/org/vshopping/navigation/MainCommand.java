package org.vshopping.navigation;

import org.vshopping.model.person.employee.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainCommand implements Command{
    private final Map<String, Command> commands = new HashMap<>();

    public MainCommand(){
        commands.put("1", new CustomerCommand());
        commands.put("2", new EmployeeCommand());
    }
    @Override
    public void exec() {
        Scanner sn = new Scanner(System.in);
        while (true) {
            System.out.println("=== GAME STORE ===");
            System.out.println("| 1 - Costumers");
            System.out.println("| 2 - Employees");
            System.out.println("| 3 - Video Games");
            System.out.println("| 4 - Orders");
            System.out.println("| 0 - Exit");
            System.out.print("Choose an option: ");
            String opt = sn.nextLine();

            if ("0".equals(opt)) {
                break;
            }

            Command command = commands.get(opt);
            if (command == null) {
                System.out.println("Invalid option");
            } else {
                command.exec();
            }
        }
    }
}
