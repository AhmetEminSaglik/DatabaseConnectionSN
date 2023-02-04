package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.SearchAlgorithmDAO;
import org.ahmeteminsaglik.entity.SearchAlgorithm;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class SearchAlgorithmDAOImp implements SearchAlgorithmDAO {
    private DBServiceDAOImp<SearchAlgorithm> dbServiceDAOImp;

    public SearchAlgorithmDAOImp() {
        dbServiceDAOImp = new DBServiceDAOImp<>(SearchAlgorithm.class);
    }

    @Override
    public void save(SearchAlgorithm searchAlgorithm) {
        dbServiceDAOImp.save(searchAlgorithm);
    }

    @Override
    public void saveAll(List<SearchAlgorithm> searchAlgorithms) {
        dbServiceDAOImp.saveAll(searchAlgorithms);
    }

    @Override
    public SearchAlgorithm getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public SearchAlgorithm getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbServiceDAOImp.getByStringValueFromGivenColumnName(columnName, value);
    }

    @Override
    public SearchAlgorithm getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }

    @Override
    public List<SearchAlgorithm> getAll() {
        return getAll(null);
    }

    @Override
    public List<SearchAlgorithm> getAll(StatementInspector statementInspector) {
        return dbServiceDAOImp.getAll(statementInspector);
    }
}
