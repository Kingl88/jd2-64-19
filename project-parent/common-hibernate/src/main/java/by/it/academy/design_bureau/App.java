package by.it.academy.design_bureau;

import by.it.academy.design_bureau.entity.Employee;
import by.it.academy.design_bureau.entity.EmployeeDetail;
import by.it.academy.design_bureau.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDateTime;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee e =
                new Employee(null, "Ivan", "Ivanov", LocalDateTime.now(), null);
        EmployeeDetail detail =
                new EmployeeDetail(null, "Street", "city", "state", "country", null);
        e.setEmployeeDetail(detail);
        detail.setEmployee(e);
        session.save(e);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
