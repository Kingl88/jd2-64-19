package by.it.academy.design_bureau.service;

import java.util.List;

/**
 * Created by User on 05.12.2019.
 */
public interface Service <T> {
    List<T> getAll();
    void addNew (T object);
    void delete (Long id);
    void update (Long id, T object);
}
