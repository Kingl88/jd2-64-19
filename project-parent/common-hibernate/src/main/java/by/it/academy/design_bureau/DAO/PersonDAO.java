package by.it.academy.design_bureau.DAO;

import by.it.academy.design_bureau.entity.Person;
import by.it.academy.design_bureau.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonDAO {
    private static final PersonDAO INSTANCE = new PersonDAO();
    private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);

    public static PersonDAO getInstance() {
        return INSTANCE;
    }

    public static void create(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void update(Person person, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        person.setId(id);
        try {
            session.update(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person = new Person();
        person.setId(id);
        try {
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person = new Person();
        person.setId(id);
        logger.info(session.load(Person.class, id).toString());
        session.getTransaction().commit();
    }
}
