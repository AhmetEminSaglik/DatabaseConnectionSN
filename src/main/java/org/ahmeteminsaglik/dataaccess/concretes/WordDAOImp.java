package org.ahmeteminsaglik.dataaccess.concretes;

import org.ahmeteminsaglik.dataaccess.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.abstracts.WordDao;
import org.ahmeteminsaglik.entities.Word;
import org.ahmeteminsaglik.entities.WordPool;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class WordDAOImp implements WordDao {
    DBService<Word> dbService;

    public WordDAOImp() {
        dbService = new DBService<Word>(Word.class);
    }

    @Override
    public void save(Word word) {
//        dbService.save(word);
        throw new NotYetImplementedException();

    }

    @Override
    public Word getById(int id) {
//        return null;
        throw new NotYetImplementedException();

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
