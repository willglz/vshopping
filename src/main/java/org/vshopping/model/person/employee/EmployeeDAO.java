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
    public Person searchPersonById(int id) {
        Employee e = null;
        for (Person person : EmployeeDB.getDataSource()) {
            if (person != null && person.getId() == id){
                e = (Employee) person;
                break;
            }
        }
        return e;
    }

    @Override
    public List<Person> getPerson() {
        return EmployeeDB.getDataSource();
    }

    @Override
    public void deletePerson(int id) {
        EmployeeDB.getDataSource().remove(this.searchPersonById(id));
    }

    @Override
    public void editPerson(Person person) {
        Employee e = (Employee) this.searchPersonById(person.getId());
        e.setFirstName(person.getFirstName());
        e.setLastName(person.getLastName());
        e.setAddress(person.getAddress());
        e.setEmail(person.getEmail());
        e.setRole(((Employee) person).getRole());
        e.setSalary(((Employee) person).getSalary());
    }
}
