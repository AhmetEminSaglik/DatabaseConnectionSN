package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.ComplexityDAO;
import org.ahmeteminsaglik.entity.Complexity;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class ComplexityDAOImp implements ComplexityDAO {
    DBServiceDAOImp<Complexity> dbServiceDAOImp;

    public ComplexityDAOImp() {
        dbServiceDAOImp = new DBServiceDAOImp<>(Complexity.class);
    }

    @Override
    public void save(Complexity complexity) {
        dbServiceDAOImp.save(complexity);
    }

    @Override
    public void saveAll(List<Complexity> complexities) {
        dbServiceDAOImp.saveAll(complexities);
    }

    @Override
    public Complexity getById(int id) {
        throw new NotYetImplementedException();    }

    @Override
    public Complexity getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbServiceDAOImp.getByStringValueFromGivenColumnName(columnName, value, statementInspector);
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
        return dbServiceDAOImp.getAll(statementInspector);
    }
}
