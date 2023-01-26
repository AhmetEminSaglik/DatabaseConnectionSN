package org.ahmeteminsaglik.API.concretes;

import org.ahmeteminsaglik.business.abstracts.DataPreparationService;
import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.core.utility.DBRecordObject;
import org.ahmeteminsaglik.enums.*;

import java.util.List;

public class DataPreparationManagement implements DataPreparationService {
    private DBRecordObject recordObject = new DBRecordObject();
    private DBService dbService = new DBManagement();

    public DataPreparationManagement(DBRecordObject recordObject) {
        this.recordObject = recordObject;
    }

    @Override
    public void setDataStructorProcess(EnumDataStructor enumDataStructor) {
        DataStructorProcess dataStructorProcess = new DataStructorProcess();
        DataStructor dataStructor = dbService.getDataStructor(enumDataStructor);
        dataStructorProcess.setDataStructorId(dataStructor.getId());

        recordObject.setDataStructorProcess(dataStructorProcess);
    }

    @Override
    public void setSortAlgorithmProcess(EnumSortAlgorithm enumSortAlgorithm) {
        SortAlgorithmProcess sortAlgorithmProcess = new SortAlgorithmProcess();
        SortAlgorithm sortAlgorithm = dbService.getSortAlgortihm(enumSortAlgorithm);
        sortAlgorithmProcess.setSortAlgorithmId(sortAlgorithm.getId());

        recordObject.setSortAlgorithmProcess(sortAlgorithmProcess);
    }

    @Override
    public void setSearchAlgorithmProcess(EnumSearchAlgorithm enumSearchAlgorithm) {
        SearchAlgorithmProcess searchAlgorithmProcess = new SearchAlgorithmProcess();
        SearchAlgorithm searchAlgorithm = dbService.getSearchAlgortihm(enumSearchAlgorithm);
        searchAlgorithmProcess.setSearchAlgorithmId(searchAlgorithm.getId());

        recordObject.setSearchAlgorithmProcess(searchAlgorithmProcess);
    }

    @Override
    public void setWordProcess(EnumWordTable enumTotalWordList, EnumWordTable enumSearchWordList, int foundWord, int missingWord) {
        WordProcess wordProcess = new WordProcess();
        WordList totalWordList = dbService.getWordList(enumTotalWordList);
        WordList searchWordList = dbService.getWordList(enumSearchWordList);

        wordProcess.setTotalWordList(totalWordList);
        wordProcess.setSearchWordList(searchWordList);
        wordProcess.setFoundWord(foundWord);
        wordProcess.setMissingWord(missingWord);

        recordObject.setWordProcess(wordProcess);
    }

    @Override
    public void setComplexityList(List<Complexity> complexityList) {
        recordObject.setComplexityList(complexityList);
    }

    @Override
    public DBRecordObject getRecordObject() {
        return recordObject;
    }


}
