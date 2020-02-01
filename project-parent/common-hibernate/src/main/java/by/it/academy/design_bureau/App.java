package by.it.academy.design_bureau;

import by.it.academy.design_bureau.DAO.impl.EmployeeDAOImplHQL;
import by.it.academy.design_bureau.entity.Employee;
import by.it.academy.design_bureau.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
@Slf4j
public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        add(sessionFactory);
        EmployeeDAOImplHQL employeeDAOImplHQL = new EmployeeDAOImplHQL();
        employeeDAOImplHQL.getAll(sessionFactory);
        employeeDAOImplHQL.getByName(sessionFactory, "Pety");
        employeeDAOImplHQL.getAllWithNameNotNull(sessionFactory);
        employeeDAOImplHQL.getSalaryGraterThan(sessionFactory, 1000L);
        employeeDAOImplHQL.getSalaryGraterThanOrderDesc(sessionFactory, 1L);
        employeeDAOImplHQL.getSalaryLessOrEqual(sessionFactory, 1000L);
        employeeDAOImplHQL.getByAgeBetween(sessionFactory, 24, 30);
        employeeDAOImplHQL.getByAgeAndName(sessionFactory, "Ivan", 25);
        employeeDAOImplHQL.getByAgeOrName(sessionFactory, "Ivan", 35);
        employeeDAOImplHQL.getEmployeeCount(sessionFactory);
        employeeDAOImplHQL.getAverageSalary(sessionFactory);
        employeeDAOImplHQL.getMaxSalary(sessionFactory);
        employeeDAOImplHQL.getMinAge(sessionFactory);

        HibernateUtil.shutdown();
    }
    public static void add(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = new Employee(null, "Ivan", 568L, 25);
        session.save(employee);
        Employee employee1 = new Employee(null, null, 1000L, 30);
        session.save(employee1);
        Employee employee2 = new Employee(null, "Pety", 1200L, 35);
        session.save(employee2);
        session.getTransaction().commit();
        session.close();
    }
}
