package by.it.academy.design_bureau.DAO;

import by.it.academy.design_bureau.entity.Employee;

import java.util.List;

public interface EmployeeDAO<T> {

    List<Employee> getAll(T object);

    List<Employee> getByName(T object, String name);

    List<Employee> getAllWithNameNotNull(T object);

    List<Employee> getSalaryGraterThan(T object, Long salary);

    List<Employee> getSalaryGraterThanOrderDesc(T object, Long salary);

    List<Employee> getSalaryLessOrEqual(T object, Long salary);

    List<Employee> getByAgeBetween(T object, Integer from, Integer to);

    List<Employee> getByAgeAndName(T object, String name, Integer age);

    List<Employee> getByAgeOrName(T object, String name, Integer age);


    // aggregation
    long getEmployeeCount(T object);

    Double getAverageSalary(T object);

    Double getMaxSalary(T object);

    long getMinAge(T object);

//    Double getAverageSalaryByDep(Long depId);
}
