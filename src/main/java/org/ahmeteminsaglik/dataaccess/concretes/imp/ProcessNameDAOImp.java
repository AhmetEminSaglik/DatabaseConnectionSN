package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.ProcessNameDAO;
import org.ahmeteminsaglik.entities.db.DataStructorProcess;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class ProcessNameDAOImp implements ProcessNameDAO {
    private DBService<ProcessName> dbService;

    public ProcessNameDAOImp() {
        dbService = new DBService<>(ProcessName.class);
    }

    @Override
    public void save(ProcessName processName) {
        dbService.save(processName);
    }

    @Override
    public void saveAll(List<ProcessName> processNameList) {
        dbService.saveAll(processNameList);
    }

    @Override
    public ProcessName getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public ProcessName getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbService.getByStringValueFromGivenColumnName(columnName, value);
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
        return dbService.getAll(statementInspector);
    }
}