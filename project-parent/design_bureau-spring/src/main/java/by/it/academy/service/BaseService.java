package by.it.academy.service;

import by.it.academy.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class BaseService<E> implements Service<E> {
    private final Class<E> clazz;

    @Autowired
    private DAO<E> abstractDAO;

    protected BaseService(Class<E> clazz){
        this.clazz = clazz;
    }

    @Override
    public E create(E e) {
        return abstractDAO.create(e);
    }

    @Override
    public E update(E e) {
        return abstractDAO.update(e);
    }

    @Override
    public E read(Serializable id) {
        return abstractDAO.read(id);
    }

    @Override
    public void delete(Serializable id) {
        abstractDAO.delete(id);
    }
}
