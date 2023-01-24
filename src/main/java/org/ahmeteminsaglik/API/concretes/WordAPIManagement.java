package org.ahmeteminsaglik.API.concretes;

import org.ahmeteminsaglik.API.abstracts.AbstractBaseAPI;
import org.ahmeteminsaglik.API.abstracts.WordAPIService;
import org.ahmeteminsaglik.entities.db.Word;
import org.ahmeteminsaglik.enums.EnumWordTable;

import java.util.List;

public class WordAPIManagement extends AbstractBaseAPI implements WordAPIService {
    @Override
    public List<Word> getWordList(EnumWordTable wordTable) {
        return dataServiceFromDB.getWords(wordTable);
    }
}
