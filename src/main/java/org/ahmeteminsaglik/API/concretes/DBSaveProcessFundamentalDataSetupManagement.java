package org.ahmeteminsaglik.API.concretes;

import org.ahmeteminsaglik.API.abstracts.DBSaveProcessFundamentalDataSetupService;
import org.ahmeteminsaglik.API.abstracts.DataServiceFromDB;
import org.ahmeteminsaglik.entities.ComplexityFundamental;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.enums.*;
import org.ahmeteminsaglik.utility.DBConfigureObject;

import java.util.ArrayList;
import java.util.List;

public class DBSaveProcessFundamentalDataSetupManagement implements DBSaveProcessFundamentalDataSetupService {
    private DBConfigureObject dbConfigureObject = new DBConfigureObject();
    private DataServiceFromDB dataServiceFromDB = new DataManagementFromDB();

    @Override
    public void setFundamentalForDataStructorProcess(EnumDataStructor enumDataStructor) {
        DataStructorProcess dataStructorProcess = new DataStructorProcess();
        DataStructor dataStructor = dataServiceFromDB.getDataStructor(enumDataStructor);

        dataStructorProcess.setDataStructorId(1);
        dbConfigureObject.setDataStructorProcess(dataStructorProcess);
    }

    @Override
    public void setFundamentalForSortAlgorithmProcess(EnumSortAlgorithm enumSortAlgorithm) {
        SortAlgorithmProcess sortAlgorithmProcess = new SortAlgorithmProcess();
        SortAlgorithm sortAlgorithm = dataServiceFromDB.getSortAlgortihm(enumSortAlgorithm);
        sortAlgorithmProcess.setSortAlgorithmId(sortAlgorithm.getId());

        dbConfigureObject.setSortAlgorithmProcess(sortAlgorithmProcess);
    }

    @Override
    public void setFundamentalForSearchAlgorithmProcess(EnumSearchAlgorithm enumSearchAlgorithm) {
        SearchAlgorithmProcess searchAlgorithmProcess = new SearchAlgorithmProcess();
        SearchAlgorithm searchAlgorithm = dataServiceFromDB.getSearchAlgortihm(enumSearchAlgorithm);
        searchAlgorithmProcess.setSearchAlgorithmId(searchAlgorithm.getId());

        dbConfigureObject.setSearchAlgorithmProcess(searchAlgorithmProcess);
    }

    @Override
    public void setFundamentalForComplexity(List<Complexity> complexityList) {
        dbConfigureObject.setComplexityList(complexityList);
    }

    @Override
    public void setFundamentalForWordProcess(EnumWordTable enumTotalWordList, EnumWordTable enumSearchWordList, int foundWord, int missingWord) {
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
