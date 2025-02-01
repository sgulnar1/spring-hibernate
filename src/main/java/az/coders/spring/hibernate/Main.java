package az.coders.spring.hibernate;

import az.coders.spring.hibernate.configs.SpringHibernateConfig;
import az.coders.spring.hibernate.dao.CategoryDao;
import az.coders.spring.hibernate.dao.ProductDao;
import az.coders.spring.hibernate.dao.impl.CategoryDaoImpl;
import az.coders.spring.hibernate.dao.impl.CommonDaoImpl;
import az.coders.spring.hibernate.domains.Category;
import az.coders.spring.hibernate.domains.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringHibernateConfig.class);
//        ProductDao categoryDao = context.getBean("productDaoImpl", ProductDao.class);
//        categoryDao.findAll(Product.class).forEach(System.out::println);
        CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDaoImpl");
        categoryDao.save(new Category("new name", "new description"));
    }
}
