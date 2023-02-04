package org.ahmeteminsaglik.business.abstracts;

import org.ahmeteminsaglik.entities.business.DBRecordObject;
import org.ahmeteminsaglik.entity.Complexity;
import org.ahmeteminsaglik.enums.*;

import java.util.List;

public interface DataPreparationService {
    void setDataStructorProcess(EnumDataStructor enumDataStructor);

    void setSortAlgorithmProcess(EnumSortAlgorithm enumSortAlgorithm);

    void setSearchAlgorithmProcess(EnumSearchAlgorithm enumSearchAlgorithm);

    void setWordProcess(EnumWordTable enumTotalWordList, EnumWordTable enumSearchWordList, int foundWord, int missingWord);

    void setComplexityList(List<Complexity> complexityList);

    DBRecordObject getRecordObject();


}
