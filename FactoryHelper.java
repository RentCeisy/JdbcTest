package com.jdbctest;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryHelper {

    static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
