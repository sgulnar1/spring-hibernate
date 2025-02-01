package az.coders.spring.hibernate.dao;

import java.util.List;

public interface CommonDao<E, T> {
    void save(E entity);
    void update(E entity);
    void delete(Class<E> entityClass, T id);
    E findById(Class<E> entityClass, T id);
    List<E> findAll(Class<E> entityClass);
}
