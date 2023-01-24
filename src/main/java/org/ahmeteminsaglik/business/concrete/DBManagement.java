package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.enums.*;

import java.util.List;

public class DBManagement implements DBService {
    final String columnName = "name";

    private DAOServiceManagement daoService = new DAOServiceManagement();

    @Override
    public List<Word> getWords(EnumWordTable enumWordTable) {
        return daoService.getWordDAO().getAll(new WordStatementInspector(enumWordTable));
    }

    @Override
    public WordList getWordList(EnumWordTable enumWordTable) {
//        StatementInspector statementInspector = new WordStatementInspector(enumWordTable.getName());
        return daoService.getWordListDAO().getByStringValueFromGivenColumnName(columnName, enumWordTable.getName());
    }

    @Override
    public DataStructor getDataStructor(EnumDataStructor enumDataStructor) {
        return daoService.getDataStructorDAO().getByStringValueFromGivenColumnName(columnName, enumDataStructor.getName());
    }

    @Override
    public SortAlgorithm getSortAlgortihm(EnumSortAlgorithm enumSortAlgorithm) {
        return daoService.getSortAlgorithmDAO().getByStringValueFromGivenColumnName(columnName, enumSortAlgorithm.getName());
    }

    @Override
    public SearchAlgorithm getSearchAlgortihm(EnumSearchAlgorithm enumSearchAlgorithm) {
        return daoService.getSearchAlgorithmDAO().getByStringValueFromGivenColumnName(columnName, enumSearchAlgorithm.getName());
    }

    @Override
    public ProcessName getProcessName(EnumProcessName enumProcessName) {
        return daoService.getProcessNameDAO().getByStringValueFromGivenColumnName(columnName, enumProcessName.getName());
    }
}
