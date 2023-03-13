package org.vshopping.model.person;

import java.util.List;

public interface PersonDAO {
    void savePerson(Person person);
    Person searchPersonById(int id);
    List<Person> getPerson();
    void deletePerson(int id);
    void editPerson(Person person);
}
