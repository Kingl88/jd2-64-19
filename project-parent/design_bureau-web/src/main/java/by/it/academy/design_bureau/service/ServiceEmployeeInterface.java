package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model_bureau.Employee;

public interface ServiceEmployeeInterface extends Service<Employee> {
    Employee getEmployeeByLastName(String lastName);
}
