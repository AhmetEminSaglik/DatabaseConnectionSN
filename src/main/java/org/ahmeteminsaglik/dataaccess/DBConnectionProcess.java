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
}
