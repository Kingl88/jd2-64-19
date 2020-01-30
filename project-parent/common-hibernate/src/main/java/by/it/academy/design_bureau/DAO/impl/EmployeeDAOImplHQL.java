package by.it.academy.design_bureau.DAO.impl;

import by.it.academy.design_bureau.DAO.EmployeeDAO;
import by.it.academy.design_bureau.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
@Slf4j
public class EmployeeDAOImplHQL implements EmployeeDAO<Session> {

    public List<Employee> getAll(Session session){
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        return employees;
    }

    public List<Employee> getByName(Session session, String name){
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee where Employee.name = name", Employee.class);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        return employees;
    }
//
//   public List<Employee> getAllWithNameNotNull(){
//        return null;
//   }
//
//    List<Employee> getSalaryGraterThan(Long salary);
//
//    List<Employee> getSalaryGraterThanOrderDesc(Long salary);
//
//    List<Employee> getSalaryLessOrEqual(Long salary);
//
//    List<Employee> getByAgeBetween(Integer from, Integer to);
//
//    List<Employee> getByAgeAndName(String name, Integer age);
//
//    List<Employee> getByAgeOrName(String name, Integer age);
//
//
//    // aggregation
//    long getEmployeeCount();
//
//    Double getAverageSalary();
//
//    Double getMaxSalary();
//
//    long getMinAge();
//
//    Double getAverageSalaryByDep(Long depId);
}
