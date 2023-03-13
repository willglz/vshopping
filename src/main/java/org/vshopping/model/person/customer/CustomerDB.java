package org.vshopping.model.person.customer;

import lombok.Getter;
import org.vshopping.model.person.Person;

import java.util.ArrayList;
import java.util.List;

public class CustomerDB {
    @Getter
    private static List<Person> dataSource;

    static {
        dataSource = new ArrayList<>();
    }
}
