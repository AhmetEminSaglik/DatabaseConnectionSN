package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.DataStructorDAO;
import org.ahmeteminsaglik.entity.DataStructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class DataStructorDAOImp implements DataStructorDAO {
    private DBServiceDAOImp<DataStructor> dbServiceDAOImp;

    public DataStructorDAOImp() {
        dbServiceDAOImp = new DBServiceDAOImp<>(DataStructor.class);
    }

    @Override
    public void save(DataStructor dataStructor) {
        dbServiceDAOImp.save(dataStructor);
    }

    @Override
    public void saveAll(List<DataStructor> dataStructorList) {
        dbServiceDAOImp.saveAll(dataStructorList);
    }

    @Override
    public DataStructor getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public DataStructor getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbServiceDAOImp.getByStringValueFromGivenColumnName(columnName, value);
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
        return dbServiceDAOImp.getAll(statementInspector);
    }
}
