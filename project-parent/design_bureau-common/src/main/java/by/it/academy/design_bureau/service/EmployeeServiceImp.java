package by.it.academy.design_bureau.service;

import by.it.academy.design_bureau.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeServiceImp implements EmployeeService {

    private static final EmployeeService INSTANCE = new EmployeeServiceImp();
    private final Map<String, Employee> users = new ConcurrentHashMap<>();

    private final List<Employee> employees;

    public EmployeeServiceImp() {
        employees = new ArrayList<>();
        employees.add(new Employee(1L,"Ivan", "Ivanov",
                "Head of Design Bureau", "210", "Ivan98",
                "IvanKb", true));
        employees.add(new Employee(2L,"Pety", "Petrov",
                "design engineer", "211", "****",
                "PetyKb", false));
        employees.add(new Employee(3L,"Alex", "Sidorov",
                "design engineer", "212", "Alex89",
                "AlexKb", false));
        users.put("IvanKb", employees.get(0));
        users.put("AlexKb", employees.get(2));
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
        AtomicLong idSeq = new AtomicLong(10);
        employee.setId(idSeq.incrementAndGet());
        employees.add(employee);
    }

    @Override
    public void delete(Long id) {
        for (Employee emp: employees) {
            if(emp.getId().equals(id)) {
                employees.remove(emp);
                return;
            }
        }
    }

    @Override
    public void update(Long id, Employee employee) {
        employees.set(Math.toIntExact(id), employee);
    }
    @Override
    public  Employee getEmployeeById(Long id) {
        for (Employee emp: employees) {
            if(emp.getId().equals(id)){
                return emp;
            }
        }
        return null;
    }

    @Override
    public Optional<Employee> findUser(String login, String password) {
        Employee user = users.get(login);
        if (user != null && password.equals(user.getPassword())) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
