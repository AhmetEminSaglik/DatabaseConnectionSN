package org.ahmeteminsaglik.dataaccess.abstracts;

import org.ahmeteminsaglik.dataaccess.DBConnection;
import org.ahmeteminsaglik.dataaccess.DBConnectionProcess;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class DBService<T> implements BaseDAO<T> {

    //    DBConnection connection;
    DBConnectionProcess connectionProcess;

    public DBService(Class<?> clazz) {
        connectionProcess = new DBConnectionProcess(clazz);
    }


    @Override
    public void save(T t) {
        connectionProcess.save(t);
    }

    @Override
    public void saveAll(List<T> tList) {
        connectionProcess.saveAll(tList);
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public T getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return (T) connectionProcess.getByStringValueFromGivenColumnName(columnName, value, statementInspector);
    }

    @Override
    public T getByStringValueFromGivenColumnName(String columnName, String value) {
        return (T) getByStringValueFromGivenColumnName(columnName, value, null);
    }


    @Override
    public List<T> getAll() {
        return getAll(null);
    }

    @Override
    public List<T> getAll(StatementInspector statementInspector) {
        return (List<T>) connectionProcess.getAll(statementInspector);

    }
}
