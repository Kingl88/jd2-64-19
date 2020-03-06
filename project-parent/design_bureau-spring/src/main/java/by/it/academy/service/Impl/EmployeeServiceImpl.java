package by.it.academy.service.Impl;

import by.it.academy.entity.Employee;
import by.it.academy.service.BaseService;
import by.it.academy.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseService<Employee> implements EmployeeService {
    protected EmployeeServiceImpl() {
        super(Employee.class);
    }
}
