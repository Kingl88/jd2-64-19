package by.it.academy.design_bureau.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by User on 1/9/2020.
 */
public class HibernateUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    static {
        ENTITY_MANAGER_FACTORY = Persistence.
                createEntityManagerFactory("by.it.academy");
    }
    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
    public static void close() {ENTITY_MANAGER_FACTORY.close();}
}
