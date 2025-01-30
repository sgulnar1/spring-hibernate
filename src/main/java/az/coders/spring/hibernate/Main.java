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
        CategoryDaoImpl categoryDaoImpl = context.getBean("categoryDaoImpl", CategoryDaoImpl.class);

        categoryDaoImpl.delete(36);
    }
}
