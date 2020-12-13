package com.helper;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@ContextConfiguration(locations = {"classpath:db-context.xml", "/SimpleCalculatorApp-servlet-test.xml"})
public class IntegrationTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @After
    public void cleanup() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("truncate table public.simple_calculation").executeUpdate();
        em.getTransaction().commit();
    }
}
