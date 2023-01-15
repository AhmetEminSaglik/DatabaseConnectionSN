package org.ahmeteminsaglik.dataaccess.abstracts;


import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public interface BaseDAO<T> {
    void save(T t);

    void saveAll(List<T> tList);

    T getById(int id);

    T getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector);

    T getByStringValueFromGivenColumnName(String columnName, String value);

    List<T> getAll();

    List<T> getAll(StatementInspector statementInspector);


}
