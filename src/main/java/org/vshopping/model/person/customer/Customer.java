package org.vshopping.model.person.customer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.vshopping.model.person.Person;
@EqualsAndHashCode
public class Customer extends Person {
    @Getter
    private int id;
    private static int lastId;
    public Customer(String firstName, String lastName, String address, String email) {
        super(firstName, lastName, address, email);
        this.id = ++lastId;
    }

    public Customer(int id, String firstName, String lastName, String address, String email) {
        super(firstName, lastName, address, email);
        this.id = id;
    }

    @Override
    public String toString() {
        String details = "---------------------";
        details += "\nCustomer ID: " + this.id;
        details += "\nFirst name: " + super.getFirstName();
        details += "\nLast name: " + super.getLastName();
        details += "\nAddress: " + super.getAddress();
        details += "\nE-mail: " + super.getEmail();
        details += "\n---------------------";
        return details;
    }
}
