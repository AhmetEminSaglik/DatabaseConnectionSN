package org.ahmeteminsaglik.business.abstracts;

import org.ahmeteminsaglik.entities.db.Complexity;
import org.ahmeteminsaglik.entities.enums.*;

import java.util.List;

public interface DBSaveProcessDataSetupService {
    void setFundamentalForDataStructorProcess(EnumDataStructor enumDataStructor);

    void setFundamentalForSortAlgorithmProcess(EnumSortAlgorithm enumSortAlgorithm);

    void setFundamentalForSearchAlgorithmProcess(EnumSearchAlgorithm enumSearchAlgorithm);

    void setFundamentalForComplexity(List<Complexity> complexityList);

    void setFundamentalForWordProcess(EnumWordTable enumTotalWordList, EnumWordTable enumSearchWordList, int foundWord, int missingWord);

}
