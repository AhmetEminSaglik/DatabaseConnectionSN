package org.ahmeteminsaglik.dataaccess.concretes;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.SearchAlgorithmDAO;
import org.ahmeteminsaglik.entities.db.SearchAlgorithm;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class SearchAlgorithmDAOImp implements SearchAlgorithmDAO {
    private DBService<SearchAlgorithm> dbService;

    public SearchAlgorithmDAOImp() {
        dbService = new DBService<>(SearchAlgorithm.class);
    }

    @Override
    public void save(SearchAlgorithm searchAlgorithm) {
        dbService.save(searchAlgorithm);
    }

    @Override
    public void saveAll(List<SearchAlgorithm> searchAlgorithms) {
        dbService.saveAll(searchAlgorithms);
    }

    @Override
    public SearchAlgorithm getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public List<SearchAlgorithm> getAll() {
        return getAll(null);
    }

    @Override
    public List<SearchAlgorithm> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}
