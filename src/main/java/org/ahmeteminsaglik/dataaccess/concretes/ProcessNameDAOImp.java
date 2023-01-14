package org.ahmeteminsaglik.dataaccess.concretes;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.ProcessNameDAO;
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
    public List<ProcessName> getAll() {
        return getAll(null);
    }

    @Override
    public List<ProcessName> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}
