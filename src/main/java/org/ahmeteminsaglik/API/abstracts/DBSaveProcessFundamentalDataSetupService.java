package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.entities.ComplexityFundamental;
import org.ahmeteminsaglik.entities.db.Complexity;
import org.ahmeteminsaglik.entities.enums.*;

import java.util.List;

public interface DBSaveProcessFundamentalDataSetupService {
//    void setProcessName(EnumProcessName enumProcessName);

//    void setElapsedTime(String elapsedTime);
//
//    void setMemoryUsage(String memoryUsage);

    void setFundamentalForDataStructorProcess(EnumDataStructor enumDataStructor);

    void setFundamentalForSortAlgorithmProcess(EnumSortAlgorithm enumSortAlgorithm);

    void setFundamentalForSearchAlgorithmProcess(EnumSearchAlgorithm enumSearchAlgorithm);


//    void setWordSearchResult(int foundWord, int missingWord);

    void setFundamentalForComplexity(List<ComplexityFundamental> complexityList);

    void setFundamentalForWordProcess(EnumWordTable enumTotalWordList, EnumWordTable enumSearchWordList, int foundWord, int missingWord);

}
