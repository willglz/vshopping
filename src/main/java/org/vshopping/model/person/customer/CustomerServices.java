package org.vshopping.model.person.customer;

import org.vshopping.model.person.Person;

import java.util.List;

public class CustomerServices {
    private CustomerDAO customerDAO = new CustomerDAO();

    public String addCustomer(Customer customer){
        this.customerDAO.savePerson(customer);
        return "Customer added successfully";
    }

    public String editCustomer(Customer customer){
        this.customerDAO.editPerson(customer);
        return "Customer edited successfully";
    }

    public String listCustomer(){
        StringBuilder sbCustomers = new StringBuilder();
        for (Person showCustomer : this.customerDAO.getPerson()) {
            sbCustomers.append(showCustomer.toString());
        }
        return sbCustomers.toString();
    }

    public List<Person> getCustomers(){
        return this.customerDAO.getPerson();
    }

    public Customer findCustomerById(int id){
        Customer c = null;
        for (Person person : this.getCustomers()) {
            if (person != null && person.getId() == id){
                c = (Customer) person;
                break;
            }
        }
        return c;
    }

    public String deleteCustomer(Person person){
        this.customerDAO.deletePerson(person);
        return "Customer deleted successfully";
    }
}
