package org.ahmeteminsaglik.dataaccess.concretes;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.RecordDAO;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.entities.db.Record;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class RecordDAOImp implements RecordDAO {
    private DBService<Record> dbService;

    public RecordDAOImp() {
        dbService = new DBService<>(Record.class);
    }

    @Override
    public void save(Record record) {
        dbService.save(record);
    }

    @Override
    public void saveAll(List<Record> records) {
        dbService.saveAll(records);
    }

    @Override
    public Record getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public Record getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbService.getByStringValueFromGivenColumnName(columnName, value);
    }

    @Override
    public Record getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }

    @Override
    public List<Record> getAll() {
        return getAll(null);
    }

    @Override
    public List<Record> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}
