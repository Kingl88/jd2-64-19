package by.it.academy.design_bureau.dao;

import by.it.academy.design_bureau.model.Employee;

import java.sql.SQLException;
import java.util.Optional;

public interface EmployeeDao extends DAO<Employee> { //интерфейс для работы с таблицей "Работники".
    Optional<Employee> getByEmployeeLogin(String login) throws SQLException;
}
