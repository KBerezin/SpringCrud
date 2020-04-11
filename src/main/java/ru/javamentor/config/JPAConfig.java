package ru.javamentor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Objects;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = {"ru.javamentor.repository"})
@EnableTransactionManagement
public class JPAConfig {
    private final Environment env;

    public JPAConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        Properties properties = new Properties();

        // Setting connection properties
        properties.put(DRIVER, Objects.requireNonNull(env.getProperty("mysql.driver")));
        properties.put(URL, Objects.requireNonNull(env.getProperty("mysql.jdbcUrl")));
        properties.put(USER, Objects.requireNonNull(env.getProperty("mysql.username")));
        properties.put(PASS, Objects.requireNonNull(env.getProperty("mysql.password")));

        // Setting Hibernate properties
        properties.put(SHOW_SQL, Objects.requireNonNull(env.getProperty("hibernate.show_sql")));
        properties.put(DIALECT, Objects.requireNonNull(env.getProperty("hibernate.dialect")));
        properties.put(FORMAT_SQL, Objects.requireNonNull(env.getProperty("hibernate.format_sql")));
        properties.put(CURRENT_SESSION_CONTEXT_CLASS, Objects.requireNonNull(
                env.getProperty("hibernate.current_session_context_class")));

        LocalContainerEntityManagerFactoryBean  factoryBean = new LocalContainerEntityManagerFactoryBean ();

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(properties);
        factoryBean.setPackagesToScan("ru.javamentor.model");

        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}