package org.ahmeteminsaglik.dataaccess.concretes.imp;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.WordDAO;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.entities.db.Word;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class WordDAOImp implements WordDAO {
    private DBService<Word> dbService;
    public WordDAOImp() {
        dbService = new DBService<>(Word.class);
    }

    @Override
    public void save(Word word) {
//        dbService.save(word);
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
        return dbService.getByStringValueFromGivenColumnName(columnName, value);
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
        return dbService.getAll(statementInspector);
    }
}
