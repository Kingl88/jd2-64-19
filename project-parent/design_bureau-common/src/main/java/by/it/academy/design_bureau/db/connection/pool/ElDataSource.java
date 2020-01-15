package by.it.academy.design_bureau.db.connection.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class ElDataSource {

    private static DataSource dataSource; //интерфейс для получения соединения с базой данных.

    public ElDataSource() {
    }

    public static void configure(ResourceBundle bundle) throws ClassNotFoundException { //конфигурация пула соединений HikariCP
        Class.forName(bundle.getString("db.driver.name")); //загрузка класса драйвера базы данных.
        HikariConfig config = new HikariConfig(); // создание объекта конфигурации
        config.setJdbcUrl(bundle.getString("db.url"));
        config.setUsername(bundle.getString("db.user.name"));
        config.setPassword(bundle.getString("db.user.password"));
        config.setMaximumPoolSize(20); // максимальное количество открытых соединений.
        config.setMinimumIdle(5); //минимальное число открытых соединений.
        dataSource = new HikariDataSource(config); //создание соединения
    }

    public static Connection getConnection() throws SQLException { // метод для получения соединения.
        check();
        return dataSource.getConnection(); //получение соединения.
    }

    public static DataSource getDataSource() throws SQLException {
        check();
        return dataSource;
    }

    private static void check() throws SQLException { //проверяем выполнение конфигурации перед получением соединения.
        if (dataSource == null) {
            throw new SQLException("Datasource is null; Need to call init() first");
        }
    }
}
