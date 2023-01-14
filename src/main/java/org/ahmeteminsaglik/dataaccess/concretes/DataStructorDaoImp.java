package org.ahmeteminsaglik.dataaccess.concretes;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.DataStructorDAO;
import org.ahmeteminsaglik.entities.db.DataStructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class DataStructorDaoImp implements DataStructorDAO {
    DBService<DataStructor> dbService;

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
    public List<DataStructor> getAll() {
        return getAll(null);
    }

    @Override
    public List<DataStructor> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}