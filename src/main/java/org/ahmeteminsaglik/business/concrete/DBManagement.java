package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.business.registeredobject.AllRegisteredObject;
import org.ahmeteminsaglik.business.registeredobject.RegisteredProcessName;
import org.ahmeteminsaglik.business.registeredobject.base.RegisteredObject;
import org.ahmeteminsaglik.core.utility.RetrivedObjectValidation;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.enums.*;

import javax.swing.*;
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
        WordList wordList = daoService.getWordListDAO().getByStringValueFromGivenColumnName(columnName, enumWordTable.getName());
        RetrivedObjectValidation.printSolutionHintIfRetrivedDataIsNull(wordList, enumWordTable.getClass());
        return wordList;
    }

    @Override
    public List<WordList> getAllWordList() {
        List<WordList> list = daoService.getWordListDAO().getAll();
        return list;
    }

    @Override
    public DataStructor getDataStructor(EnumDataStructor enumDataStructor) {
        DataStructor dataStructor = daoService.getDataStructorDAO().getByStringValueFromGivenColumnName(columnName, enumDataStructor.getName());
        RetrivedObjectValidation.printSolutionHintIfRetrivedDataIsNull(dataStructor, enumDataStructor.getClass());
        return dataStructor;
    }

    @Override
    public SortAlgorithm getSortAlgortihm(EnumSortAlgorithm enumSortAlgorithm) {

        SortAlgorithm sortAlgorithm = daoService.getSortAlgorithmDAO().getByStringValueFromGivenColumnName(columnName, enumSortAlgorithm.getName());
        RetrivedObjectValidation.printSolutionHintIfRetrivedDataIsNull(sortAlgorithm, enumSortAlgorithm.getClass());
        return sortAlgorithm;
    }

    @Override
    public SearchAlgorithm getSearchAlgortihm(EnumSearchAlgorithm enumSearchAlgorithm) {
        SearchAlgorithm searchAlgorithm = daoService.getSearchAlgorithmDAO().getByStringValueFromGivenColumnName(columnName, enumSearchAlgorithm.getName());
        RetrivedObjectValidation.printSolutionHintIfRetrivedDataIsNull(searchAlgorithm, enumSearchAlgorithm.getClass());
        return searchAlgorithm;

    }

    @Override
    public ProcessName getProcessName(EnumProcessName enumProcessName) {
//        JOptionPane.showMessageDialog(null, " Process Name e geldi registired ile deger alincak");
        RegisteredProcessName registeredProcessName = AllRegisteredObject.getRegisteredProcessName();
        ProcessName processName = registeredProcessName.getByEnum(enumProcessName);
//        ProcessName processName = daoService.getProcessNameDAO().getByStringValueFromGivenColumnName(columnName, enumProcessName.getName());
//        RetrivedObjectValidation.printSolutionHintIfRetrivedDataIsNull(processName, enumProcessName.getClass());
//        JOptionPane.showMessageDialog(null, "Alinan deger : " + processName);
        return processName;
    }
}
