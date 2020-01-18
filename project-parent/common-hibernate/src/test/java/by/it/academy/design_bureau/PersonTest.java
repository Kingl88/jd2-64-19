package by.it.academy.design_bureau;

import by.it.academy.design_bureau.entity.Person;
import by.it.academy.design_bureau.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test
    public void saveTest() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Person person = new Person(null, "Ivan", "Ivanov", 33);
            session.save(person);
            session.getTransaction().commit();
            session.beginTransaction();
            Person personFromDb = session.find(Person.class, person.getId());
            session.getTransaction().commit();
            Assert.assertEquals(person, personFromDb);
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.shutdown();
        }
    }
    @AfterClass
    public static void afterClass() throws Exception { HibernateUtil.shutdown(); }
}

