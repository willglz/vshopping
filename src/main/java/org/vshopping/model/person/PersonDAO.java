package org.vshopping.model.person;

import java.util.List;

public interface PersonDAO {
    void savePerson(Person person);
    List<Person> getPerson();
    Person findPersonById(String id);
    void deletePerson(Person person);
    void editPerson(Person person);
}
