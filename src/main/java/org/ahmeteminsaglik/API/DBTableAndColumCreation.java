package org.ahmeteminsaglik.API;

import org.ahmeteminsaglik.API.abstracts.DAOServiceManagement;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.utility.EnumUtility;
import java.util.ArrayList;
import java.util.List;

public class DBTableAndColumCreation {
    DAOServiceManagement service = new DAOServiceManagement();

    public void createAllTablesAndColumns() {
        saveAbsentProcesName();
        saveAbsentDataStructor();
        saveAbsentSortAlgorithm();
        saveAbsentSearchAlgorithm();
        saveAbsentWordListTableName();
    }


    private void saveAbsentProcesName() {
        List<ProcessName> processNameList = EnumUtility.getProcessNameListFromEnum();
        BaseDAO baseDAO = service.getProcessNameDAO();
        saveAbsentEnumValuesToDB(processNameList, baseDAO);
    }


    private void saveAbsentDataStructor() {
        List<DataStructor> dataStructorList = EnumUtility.getDataStructorListFromEnum();
        BaseDAO baseDAO = service.getDataStructorDAO();
        saveAbsentEnumValuesToDB(dataStructorList, baseDAO);
    }


    private void saveAbsentSortAlgorithm() {
        List<SortAlgorithm> sortAlgorithmList = EnumUtility.getSortAlgorithmListFromEnum();
        BaseDAO baseDAO = service.getSortAlgorithmDAO();
        saveAbsentEnumValuesToDB(sortAlgorithmList, baseDAO);
    }

    private void saveAbsentSearchAlgorithm() {
        List<SearchAlgorithm> searchAlgorithmList = EnumUtility.getSearchAlgorithmListFromEnum();
        BaseDAO baseDAO = service.getSearchAlgorithmDAO();
        saveAbsentEnumValuesToDB(searchAlgorithmList, baseDAO);
    }

    private void saveAbsentWordListTableName() {
        List<WordList> wordListFromEnum = EnumUtility.getWordListFromEnum();
        BaseDAO baseDAO = service.getWordListDAO();
        saveAbsentEnumValuesToDB(wordListFromEnum, baseDAO);
    }

    private void saveAbsentEnumValuesToDB(List<?> enumValue, BaseDAO<Object> baseDAO) {
        List<? super Object> valueListToSaveDb = new ArrayList<>();
        for (int i = 0; i < enumValue.size(); i++) {
            valueListToSaveDb.add(enumValue.get(i));
        }
        baseDAO.saveAll(valueListToSaveDb);
    }
}
