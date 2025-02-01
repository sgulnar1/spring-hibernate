package az.coders.spring.hibernate.configs;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("az.coders.spring.hibernate")
@PropertySource("database.properties")
@EnableTransactionManagement
public class SpringHibernateConfig {
    @Autowired
    Environment environment;
//
//    @Value("${datasource.url}")
//    private String url;
//    @Value("${datasource.username}")
//    private String username;
//    @Value("${datasource.password}")
//    private String password;

    @Bean
    public DataSource dataSource() {
        String url = environment.getProperty("datasource.url");
        String username = environment.getProperty("datasource.username");
        String password = environment.getProperty("datasource.password");
        System.out.println("url: " + url);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return new DriverManagerDataSource(url, username, password);
    }

    @Bean
    LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("az.coders.spring.hibernate.domains");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionManager;
    }
}
