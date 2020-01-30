package by.it.academy.design_bureau;

import by.it.academy.design_bureau.DAO.impl.EmployeeDAOImplHQL;
import by.it.academy.design_bureau.entity.Employee;
import by.it.academy.design_bureau.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.List;
@Slf4j
public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        add(session);
        session.getTransaction().commit();

        EmployeeDAOImplHQL employeeDAOImplHQL = new EmployeeDAOImplHQL();
        employeeDAOImplHQL.getAll(session);
        HibernateUtil.shutdown();
    }
    public static void add(Session session){
        Employee employee = new Employee(null, "Ivan", (long) 568, 25);
        session.save(employee);
        Employee employee1 = new Employee(null, null, (long) 1000, 30);
        session.save(employee1);
        Employee employee2 = new Employee(null, "Pety", (long) 1200, 35);
        session.save(employee2);
    }
}
