package org.vshopping.model.person.customer;

import org.vshopping.model.order.Order;
import org.vshopping.model.order.OrderServices;
import org.vshopping.model.person.Person;

import java.util.List;

public class CustomerServices {
    private CustomerDAO customerDAO = new CustomerDAO();
    private OrderServices oServices = new OrderServices();

    public String addCustomer(Customer customer){
        this.customerDAO.savePerson(customer);
        return "Customer added successfully";
    }

    public String editCustomer(Customer customer){
        this.customerDAO.editPerson(customer);
        return "Customer edited successfully";
    }

    public String listCustomer(){
        StringBuilder sbCustomers = new StringBuilder("No customers to show you");
        for (Person showCustomer : this.customerDAO.getPerson()) {
            sbCustomers.delete(0,25);
            sbCustomers.append(showCustomer.toString());
        }
        return sbCustomers.toString();
    }

    public List<Person> getCustomers(){
        return this.customerDAO.getPerson();
    }

    public Customer findCustomerById(String id){
        Customer c = null;
        for (Person person : this.getCustomers()) {
            if (person != null && person.getId() == Integer.parseInt(id)){
                c = (Customer) person;
                break;
            }
        }
        return c;
    }

    public String deleteCustomer(Customer customer){
        for (Order o: oServices.showOrders()){
            if (customer.equals(o.getCustomer())){
                return "This customer cannot be deleted because it is in active order.";
            }
        }
        this.customerDAO.deletePerson(customer);
        return "Customer deleted successfully";
    }

    public boolean verifyCustomers(){
        return this.customerDAO.getPerson().isEmpty();
    }
}
