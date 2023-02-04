package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.ProcessNameDAO;
import org.ahmeteminsaglik.entity.ProcessName;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class ProcessNameDAOImp implements ProcessNameDAO {
    private DBServiceDAOImp<ProcessName> dbServiceDAOImp;

    public ProcessNameDAOImp() {
        dbServiceDAOImp = new DBServiceDAOImp<>(ProcessName.class);
    }

    @Override
    public void save(ProcessName processName) {
        dbServiceDAOImp.save(processName);
    }

    @Override
    public void saveAll(List<ProcessName> processNameList) {
        dbServiceDAOImp.saveAll(processNameList);
    }

    @Override
    public ProcessName getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public ProcessName getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbServiceDAOImp.getByStringValueFromGivenColumnName(columnName, value);
    }

    @Override
    public ProcessName getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }

    @Override
    public List<ProcessName> getAll() {
        return getAll(null);
    }

    @Override
    public List<ProcessName> getAll(StatementInspector statementInspector) {
        return dbServiceDAOImp.getAll(statementInspector);
    }
}
