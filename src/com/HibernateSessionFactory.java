package com;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> transactionThreadLocal = new ThreadLocal<Transaction>();
    private static Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;

    static {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.err
                    .println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static void rebuildSessionFactory() {
        synchronized (sessionFactory) {
            try {
                configuration.configure(configFile);
                sessionFactory = configuration.buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }

    public static Session getSession() {
        Session session = sessionThreadLocal.get();
        try {
            if (session == null || !session.isOpen()) {
                if (sessionFactory == null) {
                    rebuildSessionFactory();
                }
                session = (sessionFactory != null) ? sessionFactory.openSession() : null;
                sessionThreadLocal.set(session);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static void closeSession() {
        Session session = sessionThreadLocal.get();
        sessionThreadLocal.set(null);
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void beginTransaction() {
        Transaction transaction = transactionThreadLocal.get();
        try {
            if (transaction == null) {
                transaction = getSession().beginTransaction();
                transactionThreadLocal.set(transaction);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void commitTransaction() {
        Transaction transaction = transactionThreadLocal.get();
        try {
            if (transaction != null) {
                transaction.commit();
            }
            transactionThreadLocal.set(null);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackTransaction() {
        Transaction transaction = transactionThreadLocal.get();
        try {
            transactionThreadLocal.set(null);
            if (transaction != null) {
                transaction.rollback();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }

    public static void setConfigFile(String configFile) {
        HibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }
}