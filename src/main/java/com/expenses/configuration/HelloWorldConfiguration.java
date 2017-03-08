//package com.expenses.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebMvc
//@EnableJpaRepositories(basePackages="com.expenses.repositories")
//@ComponentScan(basePackages = "com.expenses")
//public class HelloWorldConfiguration {
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
//        dataSource.setUrl("jdbc:hsqldb:mem:testdb");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        return dataSource;
//    }
//
//    @Bean
//    public EntityManager entityManager() {
//        return entityManagerFactory().getObject().createEntityManager();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("package.where.your.entites.like.CustSys.are.stored");
//        return em;
//    }
//}