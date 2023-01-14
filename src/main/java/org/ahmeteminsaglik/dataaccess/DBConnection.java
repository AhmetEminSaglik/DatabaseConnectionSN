package org.ahmeteminsaglik.dataaccess;

import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private Class<?> clazz;

    private Configuration configuration;
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public DBConnection(Class<?> clazz) {
        this.clazz = clazz;
    }

    private void buildConfiguration() {
        final String hibernateURL = "hibernate.cfg.xml";
        configuration = new Configuration().configure(hibernateURL).addAnnotatedClass(clazz);
    }

    private void buildFactory() {
        factory = configuration.buildSessionFactory();
    }


    private void openSession(StatementInspector statementInspector) {
        session = factory.withOptions().statementInspector(statementInspector).openSession();
    }

    private void beginTransaction() {
        transaction = session.beginTransaction();
    }

    public void configure(StatementInspector statementInspector) {
        buildConfiguration();
        buildFactory();
        openSession(statementInspector);
        beginTransaction();
    }

    public void commitTransaction() {
        transaction.commit();
    }

    public void closeAllConnection() {
        if (factory != null || factory.isOpen()) {
            factory.close();
        }
        if (session != null || session.isOpen()) {
            session.close();
        }
    }

    public Query createQuery() {
        return session.createQuery("FROM " + clazz.getSimpleName(), clazz);
    }
}
