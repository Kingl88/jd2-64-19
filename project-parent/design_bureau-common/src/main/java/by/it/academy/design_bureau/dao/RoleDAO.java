package by.it.academy.design_bureau.dao;

import by.it.academy.design_bureau.model.Employee;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public interface RoleDAO extends DAO<HashMap<Integer, String>>{
    HashMap<Integer, String> getRole() throws SQLException;
}