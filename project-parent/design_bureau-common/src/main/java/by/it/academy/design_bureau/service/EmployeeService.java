package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();
    Employee addNew (Employee employee);
    void delete (Long id);
    Employee update (Employee employee);
    Optional<Employee> getEmployeeById(Long id);
    Optional<Employee> findUserByLoginAndPassword(String login, String password);
}
