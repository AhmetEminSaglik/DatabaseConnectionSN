package org.ahmeteminsaglik.API.concretes;

import org.ahmeteminsaglik.business.concrete.DAOServiceManagement;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.core.utility.enums.EnumUtility;

import java.util.ArrayList;
import java.util.List;

public class DBTableAndColumCreation {
    DAOServiceManagement service = new DAOServiceManagement();

    public void createAllTablesAndColumns() {
        saveAbsentDataStructor();
        saveAbsentSortAlgorithm();
        saveAbsentSearchAlgorithm();
        saveAbsentWordListTableName();
        saveAbsentProcesName();
    }


    private void saveAbsentProcesName() {
        List<ProcessName> processNameList = EnumUtility.getProcessNameListFromEnum();
        BaseDAO<ProcessName> baseDAO = service.getProcessNameDAO();
        saveAbsentEnumValuesToDB(processNameList, baseDAO);
    }


    private void saveAbsentDataStructor() {
        List<DataStructor> dataStructorList = EnumUtility.getDataStructorListFromEnum();
        BaseDAO<DataStructor> baseDAO = service.getDataStructorDAO();
        saveAbsentEnumValuesToDB(dataStructorList, baseDAO);
    }


    private void saveAbsentSortAlgorithm() {
        List<SortAlgorithm> sortAlgorithmList = EnumUtility.getSortAlgorithmListFromEnum();
        BaseDAO<SortAlgorithm> baseDAO = service.getSortAlgorithmDAO();
        saveAbsentEnumValuesToDB(sortAlgorithmList, baseDAO);
    }

    private void saveAbsentSearchAlgorithm() {
        List<SearchAlgorithm> searchAlgorithmList = EnumUtility.getSearchAlgorithmListFromEnum();
        BaseDAO<SearchAlgorithm> baseDAO = service.getSearchAlgorithmDAO();
        saveAbsentEnumValuesToDB(searchAlgorithmList, baseDAO);
    }

    private void saveAbsentWordListTableName() {
        List<WordList> wordListFromEnum = EnumUtility.getWordListFromEnum();
        BaseDAO<WordList> baseDAO = service.getWordListDAO();
        saveAbsentEnumValuesToDB(wordListFromEnum, baseDAO);
    }

    private <T> void saveAbsentEnumValuesToDB(List<T> enumValue, BaseDAO<T> baseDAO) {
        List<T> valueListToSaveDb = new ArrayList<>(enumValue);
        baseDAO.saveAll(valueListToSaveDb);
    }
}
