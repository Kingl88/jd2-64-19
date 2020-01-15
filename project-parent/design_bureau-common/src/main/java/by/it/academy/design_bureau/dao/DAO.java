package by.it.academy.design_bureau.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> { //интерфейс для работы с базой данных.
    Long create(T t) throws SQLException; // создание чего-либо

    Optional<T> read(Long id) throws SQLException; //чтение чего-либо

    int update(T t) throws SQLException; //обновление чего-либо

    int delete(Long id) throws SQLException; //удаление чего-либо

    List<T> getAll() throws SQLException; //получение списка чего либо
}
