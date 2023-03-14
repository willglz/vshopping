package org.vshopping.model.person.customer;

import org.vshopping.model.person.Person;
import org.vshopping.model.person.PersonDAO;

import java.util.List;

public class CustomerDAO implements PersonDAO {
    @Override
    public void savePerson(Person person) {
        CustomerDB.getDataSource().add(person);
    }

    @Override
    public List<Person> getPerson() {
        return CustomerDB.getDataSource();
    }

    @Override
    public void deletePerson(Person person) {
        CustomerDB.getDataSource().remove(person);
    }

    @Override
    public void editPerson(Person person) {
        Customer c = (Customer) person;
        c.setFirstName(person.getFirstName());
        c.setLastName(person.getLastName());
        c.setAddress(person.getAddress());
        c.setEmail(person.getEmail());
    }
}
