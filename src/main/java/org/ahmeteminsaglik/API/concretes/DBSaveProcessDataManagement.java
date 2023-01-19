package org.ahmeteminsaglik.API.concretes;

import org.ahmeteminsaglik.business.abstracts.DBSaveProcessDataService;
import org.ahmeteminsaglik.business.abstracts.DataServiceFromDB;
import org.ahmeteminsaglik.business.concrete.DataManagementFromDB;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.enums.*;
import org.ahmeteminsaglik.core.utility.DBConfigureObject;

import java.util.List;

public class DBSaveProcessDataManagement implements DBSaveProcessDataService {
    private DBConfigureObject dbConfigureObject = new DBConfigureObject();
    private DataServiceFromDB dataServiceFromDB = new DataManagementFromDB();

    @Override
    public void setDataStructorProcess(EnumDataStructor enumDataStructor) {
        DataStructorProcess dataStructorProcess = new DataStructorProcess();
        DataStructor dataStructor = dataServiceFromDB.getDataStructor(enumDataStructor);
        dataStructorProcess.setDataStructorId(dataStructor.getId());

        dbConfigureObject.setDataStructorProcess(dataStructorProcess);
    }

    @Override
    public void setSortAlgorithmProcess(EnumSortAlgorithm enumSortAlgorithm) {
        SortAlgorithmProcess sortAlgorithmProcess = new SortAlgorithmProcess();
        SortAlgorithm sortAlgorithm = dataServiceFromDB.getSortAlgortihm(enumSortAlgorithm);
        sortAlgorithmProcess.setSortAlgorithmId(sortAlgorithm.getId());

        dbConfigureObject.setSortAlgorithmProcess(sortAlgorithmProcess);
    }

    @Override
    public void setSearchAlgorithmProcess(EnumSearchAlgorithm enumSearchAlgorithm) {
        SearchAlgorithmProcess searchAlgorithmProcess = new SearchAlgorithmProcess();
        SearchAlgorithm searchAlgorithm = dataServiceFromDB.getSearchAlgortihm(enumSearchAlgorithm);
        searchAlgorithmProcess.setSearchAlgorithmId(searchAlgorithm.getId());

        dbConfigureObject.setSearchAlgorithmProcess(searchAlgorithmProcess);
    }

    @Override
    public void setComplexityList(List<Complexity> complexityList) {
        dbConfigureObject.setComplexityList(complexityList);
    }

    @Override
    public void setWordProcess(EnumWordTable enumTotalWordList, EnumWordTable enumSearchWordList, int foundWord, int missingWord) {
        WordProcess wordProcess = new WordProcess();
        WordList totalWordList = dataServiceFromDB.getWordList(enumTotalWordList);
        WordList searchWordList = dataServiceFromDB.getWordList(enumSearchWordList);

        wordProcess.setTotalWordList(totalWordList);
        wordProcess.setSearchWordList(searchWordList);
        wordProcess.setFoundWord(foundWord);
        wordProcess.setMissingWord(missingWord);

        dbConfigureObject.setWordProcess(wordProcess);
    }

    public DBConfigureObject getDbConfigureObject() {
        return dbConfigureObject;
    }
}
