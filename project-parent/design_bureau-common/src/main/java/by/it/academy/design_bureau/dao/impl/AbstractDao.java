package by.it.academy.design_bureau.dao.impl;

import by.it.academy.design_bureau.db.connection.pool.ElDataSource;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao {

    protected final Logger logger;

    protected AbstractDao(Logger logger) {
        this.logger = logger;
    } //конструктор на вход принимает логгер.


    protected Connection getConnection() throws SQLException { //метод для получения соединения.
        return ElDataSource.getConnection();
    }

    protected void closeQuietly(AutoCloseable closeable) { //метод для закрытия соединения.
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            logger.error("Error while closing closable: " + closeable, e);
        }
    }

}