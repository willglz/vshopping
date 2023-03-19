package org.vshopping.model.person.customer;

import org.vshopping.model.data.DataSource;
import org.vshopping.model.person.Person;
import org.vshopping.model.person.PersonDAO;

import java.util.List;

public class CustomerDAO implements PersonDAO {
    private DataSource<Person> ds;
    public CustomerDAO(DataSource<Person> ds){
        this.ds = ds;
    }
    @Override
    public void savePerson(Person person) {
        ds.getDataSource().add(person);
    }

    @Override
    public List<Person> getPerson() {
        return ds.getDataSource();
    }

    @Override
    public void deletePerson(Person person) {
        ds.getDataSource().remove(person);
    }

    @Override
    public void editPerson(Person person) {
        CustomerServices temp = new CustomerServices();
        Customer c = temp.findCustomerById(String.valueOf(person.getId()));
        c.setFirstName(person.getFirstName());
        c.setLastName(person.getLastName());
        c.setAddress(person.getAddress());
        c.setEmail(person.getEmail());
    }
}
