package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImp implements EmployeeService {

    private static final EmployeeService INSTANCE = new EmployeeServiceImp();

    private final List<Employee> employees;

    public EmployeeServiceImp() {
        employees = new ArrayList<>();
        employees.add(new Employee(1L,"Ivan", "Ivanov",
                "Head of Design Bureau", "210", "****",
                "IvanKb", true));
        employees.add(new Employee(2L,"Pety", "Petrov",
                "design engineer", "211", "****",
                "PetyKb", false));
        employees.add(new Employee(3L,"Alex", "Sidorov",
                "design engineer", "212", "****",
                "AlexKb", false));
    }
    public static EmployeeService getService() {
        return INSTANCE;
    }
    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public void addNew(Employee employee) {
        employee.setId((long) employees.size()+1);
        employees.add(employee);
    }

    @Override
    public void delete(Long id) {
        employees.remove(Math.toIntExact(id));
    }

    @Override
    public void update(Long id, Employee employee) {
        employees.set(Math.toIntExact(id), employee);
    }
    @Override
    public  Employee getEmployeeByLastName(String lastName) {
        for (Employee emp: employees) {
            if(emp.getLastName().equals(lastName)){
                return emp;
            }
        }
        return null;
    }
}
