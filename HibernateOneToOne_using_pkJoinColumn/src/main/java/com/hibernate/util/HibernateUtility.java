package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by asharma on 30-11-2016.
 */
public class HibernateUtility {

    private final static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
        System.out.println("SessionFactory Object Created...");
    }

    public static synchronized SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
