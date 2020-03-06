package by.it.academy.service;

import java.io.Serializable;

public interface Service<E> {
    E create(E e);

    E update(E e);

    E read(Serializable id);

    void delete(Serializable id);

}
