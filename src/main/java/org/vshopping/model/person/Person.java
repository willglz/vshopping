package org.vshopping.model.person;

import lombok.Getter;
import lombok.Setter;

public abstract class Person {
    @Setter @Getter
    private int id;
    private static int lastId;
    @Setter @Getter
    private String firstName;
    @Setter @Getter
    private String lastName;
    @Setter @Getter
    private String address;
    @Setter @Getter
    private String email;

    protected Person(String firstName, String lastName, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.id = ++lastId;
    }
}
