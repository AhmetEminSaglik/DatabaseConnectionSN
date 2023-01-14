package org.ahmeteminsaglik.dataaccess.concretes;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.WordListDAO;
import org.ahmeteminsaglik.entities.db.WordList;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class WordListDAOImp implements WordListDAO {
    DBService<WordList> dbService;

    public WordListDAOImp() {
        dbService = new DBService<>(WordList.class);
    }

    @Override
    public void save(WordList wordList) {
        dbService.save(wordList);
    }

    @Override
    public void saveAll(List<WordList> wordLists) {
        dbService.saveAll(wordLists);
    }

    @Override
    public WordList getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public List<WordList> getAll() {
        return getAll(null);
    }

    @Override
    public List<WordList> getAll(StatementInspector statementInspector) {
        return dbService.getAll(statementInspector);
    }
}
