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
    public Person searchPersonById(int id) {
        Customer c = null;
        for (Person person : CustomerDB.getDataSource()) {
            if (person != null && person.getId() == id){
                c = (Customer) person;
                break;
            }
        }
        return c;
    }

    @Override
    public List<Person> getPerson() {
        return CustomerDB.getDataSource();
    }

    @Override
    public void deletePerson(int id) {
        CustomerDB.getDataSource().remove(this.searchPersonById(id));
    }

    @Override
    public void editPerson(Person person) {
        Customer c = (Customer) this.searchPersonById(person.getId());
        c.setFirstName(person.getFirstName());
        c.setLastName(person.getLastName());
        c.setAddress(person.getAddress());
        c.setEmail(person.getEmail());
    }
}
