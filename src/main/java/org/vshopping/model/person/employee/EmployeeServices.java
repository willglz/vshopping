package org.vshopping.model.person.employee;

import org.vshopping.model.person.Person;

import java.util.List;

public class EmployeeServices {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    public String addEmployee(Employee employee){
        for (Person person: this.showEmployees()){
            if (((Employee) person).getUser().equals(employee.getUser())){
                return "This user is already in use";
            }
        }
        this.employeeDAO.savePerson(employee);
        return "Employee added successfully";
    }

    public String editEmployee(Employee employee){
        this.employeeDAO.editPerson(employee);
        return "Employee edited successfully";
    }

    public String listEmployee(){
        StringBuilder sbEmployees = new StringBuilder("No employee to show you");
        for (Person employee : this.showEmployees()) {
            sbEmployees.delete(0,23);
            sbEmployees.append(employee.toString());
        }
        return sbEmployees.toString();
    }

    public List<Person> showEmployees(){
        return this.employeeDAO.getPerson();
    }

    public Employee findEmployeeById(String id){
        Employee e = null;
        for (Person person : this.showEmployees()) {
            if (person != null && person.getId() == Integer.parseInt(id)){
                e = (Employee) person;
                break;
            }
        }
        return e;
    }

    public Employee findEmployeeByUser(String user){
        Employee e = null;
        for (Person person : this.showEmployees()) {
            if (person != null && ((Employee) person).getUser().equals(user)){
                e = (Employee) person;
                break;
            }
        }
        return e;
    }

    public String deleteEmployee(Employee employee){
        if (employee.getId() == 1){
            return "The first user cannot be deleted";
        } else if (employee.getId() == Employee.getIdInLog()) {
            return "You cannot delete yourself";
        }
        this.employeeDAO.deletePerson(employee);
        return "Employee deleted successfully";
    }

    public boolean verifyEmployee(){
        return this.employeeDAO.getPerson().isEmpty();
    }

    public boolean logInEmployee(String user, String pass){
        for (Person person: this.showEmployees()){
            if (((Employee ) person).getUser().equals(user) &&
                    ((Employee ) person).getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
}
