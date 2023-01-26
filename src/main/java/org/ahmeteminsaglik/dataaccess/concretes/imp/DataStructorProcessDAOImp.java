package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.DataStructorProcessDAO;
import org.ahmeteminsaglik.entities.db.DataStructorProcess;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class DataStructorProcessDAOImp implements DataStructorProcessDAO {
    private DBServiceDAOImp<DataStructorProcess> dbServiceDAOImp;

    public DataStructorProcessDAOImp() {
        dbServiceDAOImp = new DBServiceDAOImp<>(DataStructorProcess.class);
    }

    @Override
    public void save(DataStructorProcess dataStructorProcess) {
        dbServiceDAOImp.save(dataStructorProcess);
    }

    @Override
    public void saveAll(List<DataStructorProcess> dataStructorProcesses) {
        dbServiceDAOImp.saveAll(dataStructorProcesses);
    }

    @Override
    public DataStructorProcess getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public DataStructorProcess getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbServiceDAOImp.getByStringValueFromGivenColumnName(columnName, value);
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
        return dbServiceDAOImp.getAll(statementInspector);
    }
}
