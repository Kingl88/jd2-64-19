package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model.Employee;

import java.util.Optional;

public interface EmployeeService extends Service<Employee> {
    Employee getEmployeeByLastName(String lastName);
    Optional<Employee> findUser(String login, String password);
}
