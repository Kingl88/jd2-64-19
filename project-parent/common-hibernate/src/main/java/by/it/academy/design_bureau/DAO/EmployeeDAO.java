package by.it.academy.design_bureau.DAO;

import by.it.academy.design_bureau.entity.Employee;
import org.hibernate.SessionFactory;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAll(SessionFactory sessionFactory);

    List<Employee> getByName(SessionFactory sessionFactory, String name);

    List<Employee> getAllWithNameNotNull(SessionFactory sessionFactory);

    List<Employee> getSalaryGraterThan(SessionFactory sessionFactory, Long salary);

    List<Employee> getSalaryGraterThanOrderDesc(SessionFactory sessionFactory, Long salary);

    List<Employee> getSalaryLessOrEqual(SessionFactory sessionFactory, Long salary);

    List<Employee> getByAgeBetween(SessionFactory sessionFactory, Integer from, Integer to);

    List<Employee> getByAgeAndName(SessionFactory sessionFactory, String name, Integer age);

    List<Employee> getByAgeOrName(SessionFactory sessionFactory, String name, Integer age);


    // aggregation
    long getEmployeeCount(SessionFactory sessionFactory);

    Double getAverageSalary(SessionFactory sessionFactory);

    Double getMaxSalary(SessionFactory sessionFactory);

    long getMinAge(SessionFactory sessionFactory);

    Double getAverageSalaryByDep(SessionFactory sessionFactory, Long depId);
}
