package org.vshopping.model.person.employee;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.PersonDAO;

import java.util.List;

public class EmployeeDAO implements PersonDAO {
    @Override
    public void savePerson(Person person) {
        EmployeeDB.getDataSource().add(person);
    }

    @Override
    public List<Person> getPerson() {
        return EmployeeDB.getDataSource();
    }

    @Override
    public void deletePerson(Person person) {
        EmployeeDB.getDataSource().remove(person);
    }

    @Override
    public void editPerson(Person person) {
        Employee e = (Employee) person;
        e.setFirstName(person.getFirstName());
        e.setLastName(person.getLastName());
        e.setAddress(person.getAddress());
        e.setEmail(person.getEmail());
        e.setRole(((Employee) person).getRole());
        e.setUser(((Employee) person).getUser());
        e.setPassword(((Employee) person).getPassword());
    }
}
