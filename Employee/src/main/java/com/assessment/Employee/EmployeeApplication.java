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

        SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);


        try {
            if (sessionFactory.isClosed())
                return sessionFactory.openSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sessionFactory.openSession();
    }
}
