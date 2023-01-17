package org.ahmeteminsaglik.API;

import org.ahmeteminsaglik.API.abstracts.DAOServiceManagement;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.enums.*;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<EnumProcessName> enumList = Arrays.asList(EnumProcessName.values());
        List<ProcessName> processNameFromEnum = new ArrayList<>();
        enumList.forEach(e -> processNameFromEnum.add(new ProcessName(e.getName())));

        BaseDAO baseDAO = service.getProcessNameDAO();
        List<ProcessName> wordListFromDB = new ArrayList<>();

        List<ProcessName> listDB = getAllDataFromDBRequestedObject(baseDAO);
        wordListFromDB.addAll(listDB);

        saveAbsentEnumValuesToDB(processNameFromEnum, wordListFromDB, baseDAO);
    }


    private void saveAbsentDataStructor() {
        List<EnumDataStructor> enumList = Arrays.asList(EnumDataStructor.values());
        List<DataStructor> dataStructorListFromEnum = new ArrayList<>();
        enumList.forEach(e -> dataStructorListFromEnum.add(new DataStructor(e.getName())));

        BaseDAO baseDAO = service.getDataStructorDAO();
        List<DataStructor> dataStructorListFromDB = new ArrayList<>();
        List<DataStructor> listDB = getAllDataFromDBRequestedObject(baseDAO);
        dataStructorListFromDB.addAll(listDB);

        saveAbsentEnumValuesToDB(dataStructorListFromEnum, dataStructorListFromDB, baseDAO);
    }


    private void saveAbsentSortAlgorithm() {
        List<EnumSortAlgorithm> enumList = Arrays.asList(EnumSortAlgorithm.values());
        List<SortAlgorithm> sortAlgorithmListFromEnum = new ArrayList<>();
        enumList.forEach(e -> sortAlgorithmListFromEnum.add(new SortAlgorithm(e.getName())));

        BaseDAO baseDAO = service.getSortAlgorithmDAO();
        List<SortAlgorithm> sortAlgorithmListFromDB = new ArrayList<>();
        List<SortAlgorithm> listDB = getAllDataFromDBRequestedObject(baseDAO);
        sortAlgorithmListFromDB.addAll(listDB);

        saveAbsentEnumValuesToDB(sortAlgorithmListFromEnum, sortAlgorithmListFromDB, baseDAO);
    }

    private void saveAbsentSearchAlgorithm() {
        List<EnumSearchAlgorithm> enumList = Arrays.asList(EnumSearchAlgorithm.values());
        List<SearchAlgorithm> searchAlgorithmListFromEnum = new ArrayList<>();
        enumList.forEach(e -> searchAlgorithmListFromEnum.add(new SearchAlgorithm(e.getName())));

        BaseDAO baseDAO = service.getSearchAlgorithmDAO();
        List<SearchAlgorithm> searchAlgorithmListFromDB = new ArrayList<>();
        List<SearchAlgorithm> listDB = getAllDataFromDBRequestedObject(baseDAO);
        searchAlgorithmListFromDB.addAll(listDB);

        saveAbsentEnumValuesToDB(searchAlgorithmListFromEnum, searchAlgorithmListFromDB, baseDAO);
    }

    private void saveAbsentWordListTableName() {
        List<EnumWordTable> enumList = Arrays.asList(EnumWordTable.values());
        List<WordList> wordListFromEnum = new ArrayList<>();
        enumList.forEach(e -> wordListFromEnum.add(new WordList(e.getName())));

        BaseDAO baseDAO = service.getWordListDAO();
        List<WordList> wordListFromDB = new ArrayList<>();
        List<WordList> listDB = getAllDataFromDBRequestedObject(baseDAO);
        wordListFromDB.addAll(listDB);

        saveAbsentEnumValuesToDB(wordListFromEnum, wordListFromDB, baseDAO);
    }

    private List<Object> getAllDataFromDBRequestedObject(BaseDAO<? extends Object> baseDAO) {
        return (List<Object>) baseDAO.getAll();
    }

    private void saveAbsentEnumValuesToDB(List<?> enumValue, List<?> valueInDB, BaseDAO<Object> baseDAO) {
        List<? super Object> valueListToSaveDb = new ArrayList<>();
        for (int i = 0; i < enumValue.size(); i++) {
            boolean dataIsFound = false;
            for (int j = 0; j < valueInDB.size(); j++) {
                if (enumValue.get(i).equals(valueInDB.get(j))) {
                    dataIsFound = true;
                    break;
                }
            }
            if (dataIsFound == false) {
                valueListToSaveDb.add(enumValue.get(i));
            }
        }
        baseDAO.saveAll(valueListToSaveDb);
    }
}
