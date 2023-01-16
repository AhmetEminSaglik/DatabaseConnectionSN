package org.ahmeteminsaglik.dataaccess.concretes;

import org.ahmeteminsaglik.dataaccess.abstracts.ComplexityDAO;
import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.entities.db.Complexity;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class ComplexityDAOImp implements ComplexityDAO {
    DBService<Complexity> dbService;

    public ComplexityDAOImp() {
        dbService = new DBService<>(Complexity.class);
    }

    @Override
    public void save(Complexity complexity) {
        dbService.save(complexity);
    }

    @Override
    public void saveAll(List<Complexity> complexities) {
        dbService.saveAll(complexities);
    }

    @Override
    public Complexity getById(int id) {
        throw new NotYetImplementedException();    }

    @Override
    public Complexity getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbService.getByStringValueFromGivenColumnName(columnName, value, statementInspector);
    }

    @Override
    public Complexity getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }

    @Override
    public List<Complexity> getAll() {
        return getAll(null);
    }

    @Override
    public List<Complexity> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}
