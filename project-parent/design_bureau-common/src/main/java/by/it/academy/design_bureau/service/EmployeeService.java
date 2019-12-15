package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model.Employee;

public interface EmployeeService extends Service<Employee> {
    Employee getEmployeeByLastName(String lastName);
}
