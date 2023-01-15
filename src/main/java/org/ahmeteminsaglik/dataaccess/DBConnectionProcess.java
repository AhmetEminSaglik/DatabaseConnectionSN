package org.ahmeteminsaglik.dataaccess;

import org.hibernate.query.Query;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionProcess {
    DBConnection connection;

    public DBConnectionProcess(Class<?> clazz) {
        connection = new DBConnection(clazz);
    }

    public List<? extends Object> getAll() {
        return getAll(null);

    }

    public List<? extends Object> getAll(StatementInspector statementInspector) {
        connection.configure(statementInspector);
        List<?> list = new ArrayList<>();
        try {
            Query query = connection.createQuery();
            list = query.getResultList();
            connection.commitTransaction();

        } catch (Exception e) {
            System.out.println("Exception occured : getAll --> " + e.getMessage());
        } finally {
            connection.closeAllConnection();
        }
        return list;

    }

    public void save(Object o) {
        try {
            connection.configure(null);
            connection.persistSession(o);
            connection.commitTransaction();
        } catch (Exception e) {
            System.out.println("Exception occured : save(Object o) --> " + e.getMessage());
        } finally {
            connection.closeAllConnection();
        }
    }


    public void saveAll(List<?> objectList) {
        int i = 0;
        int batchSize = 50;
        try {
            connection.configure(null);
            connection.setBatchSize(batchSize);
            for (i = 0; i < objectList.size(); i++) {
                connection.persistSession(objectList.get(i));
                if (i % batchSize == 0) {
                    connection.flushSession();
                    connection.clearSession();
                }
            }
            connection.commitTransaction();
        } catch (Exception e) {
            System.out.println("Exception occured : save(Object o) --> " + e.getMessage());
        } finally {
            connection.closeAllConnection();
        }
    }

    public Object getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        connection.configure(statementInspector);
        Object result = null;
        try {
            Query query = connection.createQuery(columnName, value);

            result = query.getResultList().get(0);
            connection.commitTransaction();

        } catch (Exception e) {
            System.out.println("Exception occured : getAll --> " + e.getMessage());
        } finally {
            connection.closeAllConnection();
        }
        return result;

    }
}
