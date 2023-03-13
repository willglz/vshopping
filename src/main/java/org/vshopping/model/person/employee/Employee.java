package org.vshopping.model.person.employee;

import lombok.Getter;
import lombok.Setter;
import org.vshopping.model.person.Person;

import java.util.Objects;

public class Employee extends Person {
    @Getter
    private int id;
    private static int lastId;
    @Setter @Getter
    private String role;
    @Setter @Getter
    private double salary;

    public Employee(int id, String firstName, String lastName, String address, String email, String role, double salary) {
        super(firstName, lastName, address, email);
        this.role = role;
        this.salary = salary;
        this.id = id;
    }
    public Employee(String firstName, String lastName, String address, String email, String role, double salary) {
        super(firstName, lastName, address, email);
        this.role = role;
        this.salary = salary;
        this.id = ++lastId;
    }

    @Override
    public String toString() {
        String details = "---------------------";
        details += "\nEmployee ID: " + this.id;
        details += "\nFirst name: " + super.getFirstName();
        details += "\nLast name: " + super.getLastName();
        details += "\nAddress: " + super.getAddress();
        details += "\nE-mail: " + super.getEmail();
        details += "\nRole: " + this.role;
        details += "\nSalary: $" + this.salary;
        details += "\n---------------------";
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
