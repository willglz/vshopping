package org.vshopping.model.person.employee;

import org.vshopping.model.person.Person;

import java.util.List;

public class EmployeeServices {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    public String addEmployee(Employee employee){
        this.employeeDAO.savePerson(employee);
        return "Employee added successfully";
    }

    public String editEmployee(Employee employee){
        this.employeeDAO.editPerson(employee);
        return "Employee edited successfully";
    }

    public List<Person> showEmployees(){
        return this.employeeDAO.getPerson();
    }

    public Employee findEmployeeById(int id){
        return (Employee) this.employeeDAO.searchPersonById(id);
    }

    public String deleteEmployee(int id){
        this.employeeDAO.deletePerson(id);
        return "Employee deleted successfully";
    }
}
