package org.ahmeteminsaglik.dataaccess.concretes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.resource.jdbc.spi.StatementInspector;


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

    public void setBatchSize(int size) {
        session.setJdbcBatchSize(size);
    }

    public void persistSession(Object o) {
        session.persist(o);
    }

    public void flushSession() {
        session.flush();
    }

    public void clearSession() {
        session.clear();
    }

    public void commitTransaction() {
        transaction.commit();
    }

    public void closeAllConnection() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

 /*   public void mergeSession(Object o) {
        session.merge(o);
    }*/

    public Query<?> createQuery() {
        return session.createQuery("FROM " + clazz.getSimpleName(), clazz);
    }

    public Query<?> createQuery(String columnName, String value) {
        Query<?> query = session.createQuery("FROM " + clazz.getSimpleName() + " W WHERE W." + columnName + " LIKE  :value ", clazz);
//        query.setParameter("columnName", columnName);
//        query.setParameter("value",value);
//        System.out.println("columnName : " + columnName);
        query.setParameter("value", value);
        System.out.println("clazz.getSimpleName() : " + clazz.getSimpleName());
        return query;

    }
}
