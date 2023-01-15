package org.ahmeteminsaglik.dataaccess.concretes;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.DataStructorProcessDAO;
import org.ahmeteminsaglik.entities.db.DataStructor;
import org.ahmeteminsaglik.entities.db.DataStructorProcess;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class DataStructorProcessDAOImp implements DataStructorProcessDAO {
    private DBService<DataStructorProcess> dbService;

    public DataStructorProcessDAOImp() {
        dbService = new DBService<>(DataStructorProcess.class);
    }

    @Override
    public void save(DataStructorProcess dataStructorProcess) {
        dbService.save(dataStructorProcess);
    }

    @Override
    public void saveAll(List<DataStructorProcess> dataStructorProcesses) {
        dbService.saveAll(dataStructorProcesses);
    }

    @Override
    public DataStructorProcess getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public DataStructorProcess getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbService.getByStringValueFromGivenColumnName(columnName, value);
    }

    @Override
    public DataStructorProcess getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }

    @Override
    public List<DataStructorProcess> getAll() {
        return getAll(null);
    }

    @Override
    public List<DataStructorProcess> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}
