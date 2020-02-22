package com.assessment.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;


@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmployeeApplication.class, args);
    }


    @Bean
    public Session session(EntityManagerFactory emf) {

        SessionFactory sessionFactory = null;


        try {
            if (sessionFactory == null)
                sessionFactory = emf.unwrap(SessionFactory.class);
            return sessionFactory.openSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sessionFactory.openSession();
    }
}
