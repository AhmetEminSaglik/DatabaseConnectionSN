package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.business.registeredobject.*;
import org.ahmeteminsaglik.business.registeredobject.subclass.*;
import org.ahmeteminsaglik.core.utility.RetrivedObjectValidation;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.enums.*;

import java.util.List;

public class DBManagement implements DBService {

    final String columnName = "name";

    private DAOServiceManagement daoService = new DAOServiceManagement();

    @Override
    public List<Word> getWords(EnumWordTable enumWordTable) {
        List<Word> words = daoService.getWordDAO().getAll(new WordStatementInspector(enumWordTable));
        RetrivedObjectValidation.printSolutionHintIfRetrivedDataIsNull(words, enumWordTable.getClass());
        return words;
    }

    @Override
    public WordList getWordList(EnumWordTable enumWordTable) {
        RegisteredWordList registeredWordList = AllRegisteredObject.getWordList();
        WordList wordList = registeredWordList.getByEnum(enumWordTable);
        return wordList;
    }

    @Override
    public List<WordList> getAllWordList() {
        List<WordList> list = AllRegisteredObject.getWordList().getList();
        return list;
    }

    @Override
    public DataStructor getDataStructor(EnumDataStructor enumDataStructor) {
        RegisteredDataStructor registeredDataStructor = AllRegisteredObject.getDataStructor();
        DataStructor dataStructor = registeredDataStructor.getByEnum(enumDataStructor);
        return dataStructor;
    }

    @Override
    public SortAlgorithm getSortAlgortihm(EnumSortAlgorithm enumSortAlgorithm) {
        RegisteredSortAlgorithm registeredSortAlgorithm = AllRegisteredObject.getSortAlgorithm();
        SortAlgorithm sortAlgorithm = registeredSortAlgorithm.getByEnum(enumSortAlgorithm);
        return sortAlgorithm;
    }

    @Override
    public SearchAlgorithm getSearchAlgortihm(EnumSearchAlgorithm enumSearchAlgorithm) {
        RegisteredSearchAlgorithm registeredSearchAlgorithm = AllRegisteredObject.getSearchAlgorithm();
        SearchAlgorithm searchAlgorithm = registeredSearchAlgorithm.getByEnum(enumSearchAlgorithm);
        return searchAlgorithm;

    }

    @Override
    public ProcessName getProcessName(EnumProcessName enumProcessName) {
        RegisteredProcessName registeredProcessName = AllRegisteredObject.getProcessname();
        ProcessName processName = registeredProcessName.getByEnum(enumProcessName);
        return processName;
    }
}
