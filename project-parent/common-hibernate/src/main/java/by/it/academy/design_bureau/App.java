package by.it.academy.design_bureau;

import by.it.academy.design_bureau.entity.Person;
import by.it.academy.design_bureau.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Person person = new Person(null, "Ivan", "Ivanov", 33);

        session.save(person);

        person.setName("new name");
        session.getTransaction().commit();

        HibernateUtil.shutdown();

    }
}
