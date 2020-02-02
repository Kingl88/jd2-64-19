package by.it.academy.design_bureau.DAO.impl;

import by.it.academy.design_bureau.DAO.EmployeeDAO;
import by.it.academy.design_bureau.entity.Department;
import by.it.academy.design_bureau.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;
import java.util.List;
@Slf4j
public class EmployeeDAOImplCriteria implements EmployeeDAO {
    @Override
    public List<Employee> getAll(SessionFactory sessionFactory) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot);
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public List<Employee> getByName(SessionFactory sessionFactory, String name) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot).where(cb.equal(employeeRoot.get("name"), name));
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public List<Employee> getAllWithNameNotNull(SessionFactory sessionFactory) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot).where(employeeRoot.get("name").isNotNull());
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public List<Employee> getSalaryGraterThan(SessionFactory sessionFactory, Long salary) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot).where(cb.gt(employeeRoot.get("salary"), salary));
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public List<Employee> getSalaryGraterThanOrderDesc(SessionFactory sessionFactory, Long salary) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot).where(cb.gt(employeeRoot.get("salary"), salary));
        criteria.orderBy(cb.desc(employeeRoot.get("salary")));
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public List<Employee> getSalaryLessOrEqual(SessionFactory sessionFactory, Long salary) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot).where(cb.le(employeeRoot.get("salary"), salary));
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public List<Employee> getByAgeBetween(SessionFactory sessionFactory, Integer from, Integer to) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot).where(cb.between(employeeRoot.get("age"), from, to));
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public List<Employee> getByAgeAndName(SessionFactory sessionFactory, String name, Integer age) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot).where(cb.and(cb.equal(employeeRoot.get("name"), name)), cb.equal(employeeRoot.get("age"), age));
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public List<Employee> getByAgeOrName(SessionFactory sessionFactory, String name, Integer age) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.select(employeeRoot).where(cb.or(cb.equal(employeeRoot.get("age"), age), cb.equal(employeeRoot.get("name"), name)));
        List<Employee> employees = sessionFactory.openSession().
                createQuery(criteria).getResultList();
        employees.forEach(e ->log.info(String.valueOf(e)));
        return employees;
    }

    @Override
    public long getEmployeeCount(SessionFactory sessionFactory) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        criteria.select(cb.count(criteria.from(Employee.class)));
        long count = sessionFactory.openSession().createQuery(criteria).getSingleResult();
        log.info(String.valueOf(count));
        return count;
    }

    @Override
    public Double getAverageSalary(SessionFactory sessionFactory) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Double> criteria = cb.createQuery(Double.class);
        criteria.select(cb.avg(criteria.from(Employee.class).get("salary")));
        double count = sessionFactory.openSession().createQuery(criteria).getSingleResult();
        log.info(String.valueOf(count));
        return count;
    }

    @Override
    public Double getMaxSalary(SessionFactory sessionFactory) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        criteria.select(cb.max(criteria.from(Employee.class).get("salary")));
        double maxSalary = (double)sessionFactory.openSession().createQuery(criteria).getSingleResult();
        log.info(String.valueOf(maxSalary));
        return maxSalary;
    }

    @Override
    public long getMinAge(SessionFactory sessionFactory) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        criteria.select(cb.min(criteria.from(Employee.class).get("salary")));
        long minSalary = sessionFactory.openSession().createQuery(criteria).getSingleResult();
        log.info(String.valueOf(minSalary));
        return minSalary;
    }

    @Override
    public Double getAverageSalaryByDep(SessionFactory sessionFactory, Long depId) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Double> criteria = cb.createQuery(Double.class);
        Root<Employee> employee = criteria.from(Employee.class);
        Join<Employee, Department> join = employee.join("department", JoinType.INNER);
        criteria.select(cb.avg(employee.get("salary"))).where(cb.equal(join.get("departmentId"), depId));
        Session session = sessionFactory.openSession();
        Double result = session.createQuery(criteria).getSingleResult();
        log.info(String.valueOf(result));
        session.close();
        return result;

//        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Double> criteria = cb.createQuery(Double.class);
//        Root<Employee> employee = criteria.from(Employee.class);
//        Root<Department> department = criteria.from(Department.class);
//        criteria.groupBy(department.get("departmentId"));
//        criteria.select(cb.avg(employee.get("salary"))).groupBy(department.get("departmentId"));
//        List<Double> employees = sessionFactory.openSession().createQuery(criteria).getResultList();
//        log.info(String.valueOf(employees.get(0)));
//        return null;
    }
}
