package by.it.academy.dao;

import java.io.Serializable;

public interface DAO <E> {
    E create(E e);
    E update(E e);
    E read(Serializable id);
    void delete(Serializable id);
}
