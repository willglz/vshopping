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

    public List<Person> showCustomer(){
        return this.customerDAO.getPerson();
    }

    public Customer findCustomerById(int id){
        return (Customer) this.customerDAO.searchPersonById(id);
    }

    public String deleteCustomer(int id){
        this.customerDAO.deletePerson(id);
        return "Customer deleted successfully";
    }
}
