package org.ahmeteminsaglik.API.concretes;

import org.ahmeteminsaglik.API.abstracts.DAOServiceManagement;
import org.ahmeteminsaglik.API.abstracts.DataServiceFromDB;
import org.ahmeteminsaglik.dataaccess.abstracts.*;
import org.ahmeteminsaglik.dataaccess.concretes.*;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.enums.*;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.List;

public class DataManagementFromDB implements DataServiceFromDB {
    final String columnName = "name";

    private DAOServiceManagement daoService = new DAOServiceManagement();

    @Override
    public WordList getWordList(EnumWordTable enumWordTable) {
//        StatementInspector statementInspector = new WordStatementInspector(enumWordTable.getName());
        return daoService.getWordListDAO().getByStringValueFromGivenColumnName(columnName,enumWordTable.getName());
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
