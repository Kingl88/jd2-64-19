package by.it.academy.design_bureau.service.impl;

import by.it.academy.design_bureau.dao.EmployeeDao;
import by.it.academy.design_bureau.dao.impl.EmployeeDaoImpl;
import by.it.academy.design_bureau.model.Employee;
import by.it.academy.design_bureau.security.EncryptUtils;
import by.it.academy.design_bureau.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.*;

public class EmployeeServiceImp implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImp.class);
    private static final EmployeeService INSTANCE = new EmployeeServiceImp();
    private final EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

    public EmployeeServiceImp() {
    }
    public static EmployeeService getService() {
        return INSTANCE;
    }

    @Override
    public List<Employee> getAll() {
        logger.debug("Get all students");
        try {
            return employeeDao.getAll();
        } catch (SQLException e) {
            logger.error("Error while getting all students", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Employee addNew(Employee employee) {
        logger.debug("add new student {}", employee);
        try {
            Long id = employeeDao.create(employee);
            employee.setId(id);
            logger.debug("result {}", id);
        } catch (SQLException e) {
            logger.error("Error while creating student " + employee, e);
        }
        return employee;
    }

    @Override
    public void delete(Long id) {
        logger.debug("deleting student id = {}", id);
        try {
            int delete = employeeDao.delete(id);
            logger.debug("result {}", delete);
        } catch (SQLException e) {
            logger.error("Error while deleting student id=" + id, e);
        }
    }

    @Override
    public Employee update(Employee employee) {
        logger.debug("updating student {}", employee);
        try {
            int update = employeeDao.update(employee);
            logger.debug("result {}", update);
        } catch (SQLException e) {
            logger.error("Error while updating student " + employee, e);
        }
        return employee;
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        logger.debug("Get student by id {}", id);
        try {
            Optional<Employee> employee = employeeDao.read(id);
            logger.debug("result {}", employee);
            return employee;
        } catch (SQLException e) {
            logger.error("Error while getting student by id " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findUserByLoginAndPassword(String login, String password) {
        try {
            Optional<Employee> userOption = employeeDao.getByEmployeeLogin(login);
            if (userOption.isPresent()) {
                Employee employee = userOption.get();
                String hash = EncryptUtils.getSHA256(password, employee.getSalt());
                if (employee.getPassword().equals(hash)) {
                    return Optional.of(employee);
                }
            }
        } catch (SQLException e) {
            logger.error("Error find user by login and password " + login, e);
        }
        return Optional.empty();
    }
}
