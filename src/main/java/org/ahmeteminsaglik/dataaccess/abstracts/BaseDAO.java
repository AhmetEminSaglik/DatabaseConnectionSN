package org.ahmeteminsaglik.dataaccess.abstracts;


import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public interface BaseDAO<T> {
    void save(T t);

    T getById(int id);

    List<T> getAll();
    List<T> getAll(StatementInspector statementInspector);



}
