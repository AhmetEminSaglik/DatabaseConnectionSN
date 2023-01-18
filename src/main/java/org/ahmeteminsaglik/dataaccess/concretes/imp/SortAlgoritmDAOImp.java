package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.SortAlgorithmDAO;
import org.ahmeteminsaglik.entities.db.SortAlgorithm;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class SortAlgoritmDAOImp implements SortAlgorithmDAO {
    private DBService<SortAlgorithm> dbService;

    public SortAlgoritmDAOImp() {
        this.dbService = new DBService<>(SortAlgorithm.class);
    }

    @Override
    public void save(SortAlgorithm sortAlgorithm) {
        dbService.save(sortAlgorithm);
    }

    @Override
    public void saveAll(List<SortAlgorithm> sortAlgorithms) {
        dbService.saveAll(sortAlgorithms);
    }

    @Override
    public SortAlgorithm getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public SortAlgorithm getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbService.getByStringValueFromGivenColumnName(columnName, value);
    }

    @Override
    public SortAlgorithm getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }
    @Override
    public List<SortAlgorithm> getAll() {
        return getAll(null);
    }

    @Override
    public List<SortAlgorithm> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}
