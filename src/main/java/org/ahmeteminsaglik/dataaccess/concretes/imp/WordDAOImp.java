package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.WordDAO;
import org.ahmeteminsaglik.entity.Word;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class WordDAOImp implements WordDAO {
    private DBServiceDAOImp<Word> dbServiceDAOImp;
    public WordDAOImp() {
        dbServiceDAOImp = new DBServiceDAOImp<>(Word.class);
    }

    @Override
    public void save(Word word) {
//        dbServiceDAOImp.save(word);
        throw new NotYetImplementedException();
    }

    @Override
    public void saveAll(List<Word> words) {
        throw new NotYetImplementedException();

    }

    @Override
    public Word getById(int id) {
//        return null;
        throw new NotYetImplementedException();

    }

    @Override
    public Word getByStringValueFromGivenColumnName(String columnName, String value, StatementInspector statementInspector) {
        return dbServiceDAOImp.getByStringValueFromGivenColumnName(columnName, value);
    }

    @Override
    public Word getByStringValueFromGivenColumnName(String columnName, String value) {
        return getByStringValueFromGivenColumnName(columnName, value, null);
    }

    @Override
    public List<Word> getAll() {
        return getAll(null);
    }

    @Override
    public List<Word> getAll(StatementInspector statementInspector) {
        return dbServiceDAOImp.getAll(statementInspector);
    }
}
