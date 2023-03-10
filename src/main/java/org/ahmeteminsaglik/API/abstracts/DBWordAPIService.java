package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.entities.db.Word;
import org.ahmeteminsaglik.enums.EnumWordTable;

import java.util.List;

public interface DBWordAPIService {
    List<Word> getWords(EnumWordTable enumWordTable);
}
