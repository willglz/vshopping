package org.vshopping.model.person.employee;

import lombok.Getter;
import org.vshopping.model.person.Person;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {
    @Getter
    private static List<Person> dataSource;

    static {
        dataSource = new ArrayList<>();
    }
}
