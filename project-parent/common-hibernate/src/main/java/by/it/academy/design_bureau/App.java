package by.it.academy.design_bureau;

import by.it.academy.design_bureau.entity.Department;
import by.it.academy.design_bureau.entity.Employee;
import by.it.academy.design_bureau.entity.Meeting;
import by.it.academy.design_bureau.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = new Employee(null, "Ivan", "Ivanov",LocalDateTime.now(), null, null, new ArrayList<>());
        Meeting meeting = new Meeting("Hibernate relation grooming");
        meeting.getEmployees().add(employee);
        session.save(meeting);
        employee.getMeetings().add(meeting);
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
