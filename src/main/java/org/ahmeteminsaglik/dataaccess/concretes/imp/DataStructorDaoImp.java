package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.DataStructorDAO;
import org.ahmeteminsaglik.entities.db.DataStructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class DataStructorDaoImp implements DataStructorDAO {
    private DBService<DataStructor> dbService;

    public DataStructorDaoImp() {
        dbService = new DBService<>(DataStructor.class);
    }

    @Override
    public void save(DataStructor dataStructor) {
        dbService.save(dataStructor);
    }

    @Override
    public void saveAll(List<DataStructor> dataStructorList) {
        dbService.saveAll(dataStructorList);
    }

    @Override
    public DataStructor getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public DataStructor getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbService.getByStringValueFromGivenColumnName(columnName, value);
    }

    @Override
    public DataStructor getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }


    @Override
    public List<DataStructor> getAll() {
        return getAll(null);
    }

    @Override
    public List<DataStructor> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}
