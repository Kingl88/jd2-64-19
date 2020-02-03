package by.it.academy.design_bureau.DAO.impl;

import by.it.academy.design_bureau.DAO.EmployeeDAO;
import by.it.academy.design_bureau.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
@Slf4j
public class EmployeeDAOImplHQL implements EmployeeDAO {

    public List<Employee> getAll(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public List<Employee> getByName(SessionFactory sessionFactory, String byName){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee where name =:name", Employee.class);
        query.setParameter("name", byName);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public List<Employee> getAllWithNameNotNull(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee where name is NOT null ", Employee.class);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
   }

    public List<Employee> getSalaryGraterThan(SessionFactory sessionFactory, Long salary) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee where salary >: salary", Employee.class);
        query.setParameter("salary", salary);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public List<Employee> getSalaryGraterThanOrderDesc(SessionFactory sessionFactory, Long salary){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee e where salary >: salary ORDER BY e.salary DESC", Employee.class);
        query.setParameter("salary", salary);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public List<Employee> getSalaryLessOrEqual(SessionFactory sessionFactory, Long salary){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee e where salary <=: salary", Employee.class);
        query.setParameter("salary", salary);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public List<Employee> getByAgeBetween(SessionFactory sessionFactory, Integer from, Integer to){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee e where age between :from AND :to", Employee.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public List<Employee> getByAgeAndName(SessionFactory sessionFactory, String name, Integer age){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee e where name =: name and age=: age", Employee.class);
        query.setParameter("name", name);
        query.setParameter("age", age);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public List<Employee> getByAgeOrName(SessionFactory sessionFactory, String name, Integer age){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Employee> query =
                session.createQuery("FROM Employee e where name =: name or age=: age", Employee.class);
        query.setParameter("name", name);
        query.setParameter("age", age);
        List<Employee> employees = query.list();
        log.info(employees.toString());
        session.getTransaction().commit();
        session.close();
        return employees;
    }


    // aggregation
    public long getEmployeeCount(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Long> query =
                session.createQuery("select COUNT(*) FROM Employee e", Long.class);
        Long employees = query.getSingleResult();
        log.info(String.valueOf(employees));
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public Double getAverageSalary(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Double> query =
                session.createQuery("select AVG (salary) FROM Employee e", Double.class);
        Double employees = query.getSingleResult();
        log.info(String.valueOf(employees));
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public Double getMaxSalary(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Long> query =
                session.createQuery("select MAX(salary) FROM Employee e", Long.class);
        Double maxSalary = Double.valueOf(query.getSingleResult());
        log.info(String.valueOf(maxSalary));
        session.getTransaction().commit();
        session.close();
        return maxSalary;
    }

    public long getMinAge(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Integer> query =
                session.createQuery("select MIN (age) FROM Employee e", Integer.class);
        Integer minAge = query.getSingleResult();
        log.info(String.valueOf(minAge));
        session.getTransaction().commit();
        session.close();
        return minAge;
    }

    public Double getAverageSalaryByDep(SessionFactory sessionFactory, Long depId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Double> query =
                session.createQuery("select AVG(salary) FROM Employee group by department.departmentId", Double.class);
        List<Double> avgSalaryByDep = query.list();
        int index = Math.toIntExact(--depId);
        log.info(avgSalaryByDep.get(index).toString());
        session.getTransaction().commit();
        session.close();
        return avgSalaryByDep.get(index);
    }
}
