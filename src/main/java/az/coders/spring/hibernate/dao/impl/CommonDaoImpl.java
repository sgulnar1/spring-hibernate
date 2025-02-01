package az.coders.spring.hibernate.dao.impl;

import az.coders.spring.hibernate.dao.CommonDao;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CommonDaoImpl<E, T> implements CommonDao<E, T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(E entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    @Override
    public void update(E entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public void delete(Class<E> entityClass, T id) {
        sessionFactory.getCurrentSession().remove(findById(entityClass, id));
    }

    @Override
    public E findById(Class<E> entityClass, T id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public List<E> findAll(Class<E> entityClass) {
        return sessionFactory.getCurrentSession().createQuery("from "+entityClass.getName()).list();

    }
}
