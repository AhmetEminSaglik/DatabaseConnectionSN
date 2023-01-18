package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.entities.db.Word;
import org.ahmeteminsaglik.entities.enums.EnumWordTable;

import java.util.List;

public interface WordAPIService {
    List<Word> getWordList(EnumWordTable wordTable);

}
