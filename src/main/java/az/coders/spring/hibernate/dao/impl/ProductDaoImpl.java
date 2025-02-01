package az.coders.spring.hibernate.dao.impl;

import az.coders.spring.hibernate.dao.ProductDao;
import az.coders.spring.hibernate.domains.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductDaoImpl extends CommonDaoImpl<Product, Integer> implements ProductDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void save(Product product) {
//        sessionFactory.getCurrentSession().persist(product);
//    }
//
//    @Override
//    public void update(Product product) {
//        sessionFactory.getCurrentSession().merge(product);
//    }
//
//    @Override
//    public void delete(int id) {
//        sessionFactory.getCurrentSession().remove(findById(id));
//
//    }
//
//    @Override
//    public Product findById(int id) {
//        return sessionFactory.getCurrentSession().get(Product.class, id);
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return sessionFactory.getCurrentSession().createQuery("from Product").list();
//    }
}
