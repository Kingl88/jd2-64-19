package by.it.academy.design_bureau;

import by.it.academy.design_bureau.entity.Person;
import by.it.academy.design_bureau.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

/**
 * Created by User on 1/9/2020.
 */
public class PersonTest {
    @Test
    public void saveTest() {
        Person person = new Person(null, "Ivan", "Ivanov", 33);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            Person personFromDb = entityManager.find(Person.class, person.getId());
            Assert.assertEquals(person, personFromDb);
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
    @AfterClass
    public static void afterClass() throws Exception { HibernateUtil.close(); }
}

