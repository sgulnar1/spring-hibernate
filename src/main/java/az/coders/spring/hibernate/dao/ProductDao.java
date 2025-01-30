package az.coders.spring.hibernate.dao;

import az.coders.spring.hibernate.domains.Category;
import az.coders.spring.hibernate.domains.Product;

import java.util.List;

public interface ProductDao {
    void save(Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> findAll();
}
