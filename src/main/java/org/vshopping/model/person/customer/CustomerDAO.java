package org.vshopping.model.person.customer;

import org.vshopping.model.data.DataSource;
import org.vshopping.model.person.Person;
import org.vshopping.model.person.PersonDAO;

import java.util.List;

public class CustomerDAO implements PersonDAO {
    private final DataSource<Person> personDataSource;
    private Customer customer;
    public CustomerDAO(DataSource<Person> personDataSource, Customer customer){
        this.personDataSource = personDataSource;
        this.customer = customer;
    }
    @Override
    public void savePerson(Person person) {
        personDataSource.getDataSource().add(person);
    }

    @Override
    public List<Person> getPerson() {
        return personDataSource.getDataSource();
    }

    @Override
    public Person findPersonById(String id) {
        customer = null;
        for (Person person : this.getPerson()) {
            if (person != null && person.getId() == Integer.parseInt(id)){
                customer = (Customer) person;
                break;
            }
        }
        return customer;
    }

    @Override
    public void deletePerson(Person person) {
        personDataSource.getDataSource().remove(person);
    }

    @Override
    public void editPerson(Person person) {
        customer = (Customer) this.findPersonById(String.valueOf(person.getId()));
        customer.setFirstName(person.getFirstName());
        customer.setLastName(person.getLastName());
        customer.setAddress(person.getAddress());
        customer.setEmail(person.getEmail());
    }
}
