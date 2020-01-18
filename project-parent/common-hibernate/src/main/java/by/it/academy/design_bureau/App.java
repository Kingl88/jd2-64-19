package by.it.academy.design_bureau;

import by.it.academy.design_bureau.DAO.PersonDAO;
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
        Person person = new Person(null, "hjhkhj", "gdfgd", 45);
        PersonDAO.create(person);
        PersonDAO.read((long) 1);
        Person person1 = new Person(null, "dfdfdsf", "dgfdsgds", 15);
        PersonDAO.update(person1, (long)1);
        PersonDAO.read((long)1);
        PersonDAO.delete((long)1);
        HibernateUtil.shutdown();

    }
}
