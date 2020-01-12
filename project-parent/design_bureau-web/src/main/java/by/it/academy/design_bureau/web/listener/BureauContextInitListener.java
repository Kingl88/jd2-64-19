package by.it.academy.design_bureau.web.listener;

import by.it.academy.design_bureau.db.connection.pool.ElDataSource;
import by.it.academy.design_bureau.db.migration.DbMigration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.util.ResourceBundle;

@WebListener()
public class BureauContextInitListener implements ServletContextListener { // класс "слушателя", запускается перед запуском приложения.

    private static final Logger logger = LoggerFactory.getLogger(BureauContextInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("mysql_hikari");
            ElDataSource.configure(bundle);
            DataSource dataSource = ElDataSource.getDataSource();
            DbMigration.migrate(dataSource);
        } catch (Exception e) {
            logger.error("error", e);
            throw new RuntimeException("Datasource initialisation error", e);
        }
        logger.info("Context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context destroyed");
    }
}
