package az.coders.spring.hibernate.dao;

import java.util.List;

public interface CommonDao<E, T> {
    void save(E entity);
    void update(E entity);
    void delete(T id);
    E findById(T id);
    List<E> findAll();
}
