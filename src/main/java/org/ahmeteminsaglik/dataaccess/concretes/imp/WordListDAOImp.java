package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.WordListDAO;
import org.ahmeteminsaglik.entities.db.WordList;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class WordListDAOImp implements WordListDAO {
    private DBServiceDAOImp<WordList> dbServiceDAOImp;

    public WordListDAOImp() {
        dbServiceDAOImp = new DBServiceDAOImp<>(WordList.class);
    }

    @Override
    public void save(WordList wordList) {
        dbServiceDAOImp.save(wordList);
    }

    @Override
    public void saveAll(List<WordList> wordLists) {
        dbServiceDAOImp.saveAll(wordLists);
    }

    @Override
    public WordList getById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public WordList getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbServiceDAOImp.getByStringValueFromGivenColumnName(columnName, value);
    }

    @Override
    public WordList getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }

    @Override
    public List<WordList> getAll() {
        return getAll(null);
    }

    @Override
    public List<WordList> getAll(StatementInspector statementInspector) {
        return dbServiceDAOImp.getAll(statementInspector);
    }

}
