package by.it.academy.dao.impl;

import by.it.academy.dao.BaseDao;
import by.it.academy.dao.EmployeeDao;
import by.it.academy.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
    public EmployeeDaoImpl() {
        super(Employee.class);
    }
}
