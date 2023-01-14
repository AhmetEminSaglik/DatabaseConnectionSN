package org.ahmeteminsaglik;

import org.ahmeteminsaglik.dataaccess.abstracts.*;
import org.ahmeteminsaglik.dataaccess.concretes.*;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.db.Record;
import org.ahmeteminsaglik.entities.enums.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBProcessAPI {
    public static void exampleSaveSearchAlgorithmProcess() {
        Record record = new Record();
//        DataStructorProcessDAO DSPdao = new DataStructorProcessDAOImp();
        RecordDAO dao = new RecordDAOImp();

        SearchAlgorithmProcess sap = new SearchAlgorithmProcess();
        sap.setRecordId(record);
        sap.setSearchAlgorithmId(9);

        SearchAlgorithmProcess sap2 = new SearchAlgorithmProcess();
        sap2.setRecordId(record);
        sap2.setSearchAlgorithmId(2);

        SearchAlgorithmProcess dsp3 = new SearchAlgorithmProcess();
        dsp3.setRecordId(record);
        dsp3.setSearchAlgorithmId(3);

        SearchAlgorithmProcess dsp4 = new SearchAlgorithmProcess();
        dsp4.setRecordId(record);
        dsp4.setSearchAlgorithmId(1);

        record.getSearchAlgorithmProcessList().add(sap);
        record.getSearchAlgorithmProcessList().add(sap2);
        record.getSearchAlgorithmProcessList().add(dsp3);
        record.getSearchAlgorithmProcessList().add(dsp4);

        dao.save(record);
    }


    public static void exampleSaveSortAlgorithmProcess() {
        Record record = new Record();
//        DataStructorProcessDAO DSPdao = new DataStructorProcessDAOImp();
        RecordDAO dao = new RecordDAOImp();

        SortAlgorithmProcess sap = new SortAlgorithmProcess();
        sap.setRecordId(record);
        sap.setSortAlgorithmId(2);

        SortAlgorithmProcess sap2 = new SortAlgorithmProcess();
        sap2.setRecordId(record);
        sap2.setSortAlgorithmId(1);

        SortAlgorithmProcess dsp3 = new SortAlgorithmProcess();
        dsp3.setRecordId(record);
        dsp3.setSortAlgorithmId(3);

        SortAlgorithmProcess dsp4 = new SortAlgorithmProcess();
        dsp4.setRecordId(record);
        dsp4.setSortAlgorithmId(5);

        record.getSortAlgorithmProcessList().add(sap);
        record.getSortAlgorithmProcessList().add(sap2);
        record.getSortAlgorithmProcessList().add(dsp3);
        record.getSortAlgorithmProcessList().add(dsp4);

        dao.save(record);
    }


    public static void exampleSaveDataStructorProcess() {
        Record record = new Record();
//        DataStructorProcessDAO DSPdao = new DataStructorProcessDAOImp();
        RecordDAO dao = new RecordDAOImp();
        DataStructorProcess dsp = new DataStructorProcess();
        dsp.setRecordId(record);
        dsp.setDataStructorId(2);

        DataStructorProcess dsp2 = new DataStructorProcess();
        dsp2.setRecordId(record);
        dsp2.setDataStructorId(1);

        DataStructorProcess dsp3 = new DataStructorProcess();
        dsp3.setRecordId(record);
        dsp3.setDataStructorId(3);

        record.getDataStructorProcessList().add(dsp);
        record.getDataStructorProcessList().add(dsp2);
        record.getDataStructorProcessList().add(dsp3);

        dao.save(record);
    }

    public static void exampleSaveRecord() {
        RecordDAO recordDAO = new RecordDAOImp();
        /*List<Record> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Record());
        }
        recordDAO.saveAll(list);*/
        Record record = new Record();
        recordDAO.save(record);
    }

    public static void exampleSaveAbsentProcesName() {

        List<EnumProcessName> enumList = Arrays.asList(EnumProcessName.values());
        List<ProcessName> processNameFromEnum = new ArrayList<>();
        enumList.forEach(e -> processNameFromEnum.add(new ProcessName(e.getName())));

        BaseDAO baseDAO = new ProcessNameDAOImp();
        List<ProcessName> wordListFromDB = new ArrayList<>();

        List<Object> listDB = exampleGetAllDataFromDBRequestedObject(baseDAO);
        listDB.forEach(e -> {
            wordListFromDB.add((ProcessName) e);
            System.out.println("added item : " + ((ProcessName) e).getName());
        });

        saveAbsentEnumValuesToDB(processNameFromEnum, wordListFromDB, baseDAO);
    }

    public static void exampleSaveAbsentWordListTableName() {

        List<EnumWordTable> enumList = Arrays.asList(EnumWordTable.values());
        List<WordList> wordListFromEnum = new ArrayList<>();
        enumList.forEach(e -> wordListFromEnum.add(new WordList(e.getName())));

        BaseDAO baseDAO = new WordListDAOImp();
        List<WordList> wordListFromDB = new ArrayList<>();

        List<Object> listDB = exampleGetAllDataFromDBRequestedObject(baseDAO);
        listDB.forEach(e -> {
            wordListFromDB.add((WordList) e);
            System.out.println("added item : " + ((WordList) e).getName());
        });

        saveAbsentEnumValuesToDB(wordListFromEnum, wordListFromDB, baseDAO);
    }

    public static void exampleSaveAbsentSearchAlgorithm() {

        List<EnumSearchAlgorithm> enumList = Arrays.asList(EnumSearchAlgorithm.values());
        List<SearchAlgorithm> searchAlgorithmListFromEnum = new ArrayList<>();
        enumList.forEach(e -> searchAlgorithmListFromEnum.add(new SearchAlgorithm(e.getName())));

        BaseDAO baseDAO = new SearchAlgorithmDAOImp();
        List<SearchAlgorithm> searchAlgorithmListFromDB = new ArrayList<>();

        List<Object> listDB = exampleGetAllDataFromDBRequestedObject(baseDAO);
        listDB.forEach(e -> {
            searchAlgorithmListFromDB.add((SearchAlgorithm) e);
        });

        saveAbsentEnumValuesToDB(searchAlgorithmListFromEnum, searchAlgorithmListFromDB, baseDAO);
    }

    public static void exampleSaveAbsentSortAlgorithm() {

        List<EnumSortAlgorithm> enumList = Arrays.asList(EnumSortAlgorithm.values());
        List<SortAlgorithm> sortAlgorithmListFromEnum = new ArrayList<>();
        enumList.forEach(e -> sortAlgorithmListFromEnum.add(new SortAlgorithm(e.getName())));

        BaseDAO baseDAO = new SortAlgoritmDAOImp();
        List<SearchAlgorithm> searchAlgorithmListFromDB = new ArrayList<>();

        List<Object> listDB = exampleGetAllDataFromDBRequestedObject(baseDAO);
        listDB.forEach(e -> {
            searchAlgorithmListFromDB.add((SearchAlgorithm) e);
        });

        saveAbsentEnumValuesToDB(sortAlgorithmListFromEnum, searchAlgorithmListFromDB, baseDAO);
    }

    public static void saveAbsentEnumValuesToDB(List<?> enumValue, List<?> valueInDB, BaseDAO<Object> baseDAO) {
        for (int i = 0; i < enumValue.size(); i++) {
            boolean dataIsFound = false;
            for (int j = 0; j < valueInDB.size(); j++) {
                if (enumValue.get(i).equals(valueInDB.get(j))) {
                    dataIsFound = true;
                    break;
                }
            }
            if (dataIsFound == false) {
                baseDAO.save(enumValue.get(i));
            }
        }

    }

    public static List<Object> exampleGetAllDataFromDBRequestedObject(BaseDAO<? extends Object> baseDAO) {
        return (List<Object>) baseDAO.getAll();

    }


    public static void exampleGetAllRequestedWordTableWords() {
        WordDAO wordDAO = new WordDAOImp();
        String tableName = EnumWordTable.selectTableName(EnumWordTable.WORD_1_000);
        WordStatementInspector statementInspector = new WordStatementInspector(tableName);
        System.out.println(statementInspector);
        List<Word> wordList = wordDAO.getAll(statementInspector);

        wordList.stream().forEach(e -> {
            System.out.println(e);
        });
        System.out.println("wordList.size() : " + wordList.size());
    }

    public static List<DataStructor> exampleGetAllDataStructor() {
        DataStructorDAO dataStructorDAO = new DataStructorDaoImp();
        List<DataStructor> list = dataStructorDAO.getAll();
        return list;
    }


    public static void exampleSaveDataToDataStructor() {
        Object[] dsArr = Arrays.stream(EnumDataStructor.values()).toArray();
        List<DataStructor> list = new ArrayList<>();

        Arrays.stream(dsArr).forEachOrdered(
                e -> {
                    DataStructor dataStructor = new DataStructor(((EnumDataStructor) e).getName());
//                    saveDataStructor(dataStructor);
                    list.add(dataStructor);
                }
        );
        saveAllDataStructor(list);
    }

    public static void exampleSaveAbsentDataStructor() {
        List<DataStructor> listDB = exampleGetAllDataStructor();
        Object[] dsArr = Arrays.stream(EnumDataStructor.values()).toArray();

        for (int i = 0; i < dsArr.length; i++) {
            boolean dataIsFound = false;
            EnumDataStructor enumDSN = ((EnumDataStructor) dsArr[i]);
            for (int j = 0; j < listDB.size(); j++) {

                if (listDB.get(j).getName().equals(enumDSN.getName())) {
                    dataIsFound = true;
                    break;
                }
            }
            if (dataIsFound == false) {
                saveDataStructor(new DataStructor(enumDSN.getName()));
            }
        }
    }


    public static void saveDataStructor(DataStructor dataStructor) {

        DataStructorDAO dao = new DataStructorDaoImp();
        dao.save(dataStructor);

    }

    public static void saveAllDataStructor(List<DataStructor> dataStructorList) {
        DataStructorDAO dao = new DataStructorDaoImp();
        dao.saveAll(dataStructorList);
    }

}
