package org.ahmeteminsaglik.business.abstracts;

import org.ahmeteminsaglik.entities.db.Complexity;
import org.ahmeteminsaglik.entities.enums.*;

import java.util.List;

public interface DBSaveProcessDataService {
    void setDataStructorProcess(EnumDataStructor enumDataStructor);

    void setSortAlgorithmProcess(EnumSortAlgorithm enumSortAlgorithm);

    void setSearchAlgorithmProcess(EnumSearchAlgorithm enumSearchAlgorithm);

    void setComplexityList(List<Complexity> complexityList);

    void setWordProcess(EnumWordTable enumTotalWordList, EnumWordTable enumSearchWordList, int foundWord, int missingWord);

}
