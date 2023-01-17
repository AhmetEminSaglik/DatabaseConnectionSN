package org.ahmeteminsaglik.API;

import org.ahmeteminsaglik.API.abstracts.DBSaveProcessAPIService;
import org.ahmeteminsaglik.dataaccess.abstracts.*;
import org.ahmeteminsaglik.dataaccess.concretes.*;
import org.ahmeteminsaglik.entities.db.Record;
import org.ahmeteminsaglik.utility.DBConfigureObject;

import java.util.ArrayList;
import java.util.List;

public class DBSaveProcessAPI implements DBSaveProcessAPIService {
    private RecordDAO recordDAO = new RecordDAOImp();

    @Override
    public void save(DBConfigureObject dbConfigureObject) {
        recordDAO.save(dbConfigureObject.getRecord());
    }

    @Override
    public void save(List<DBConfigureObject> dbConfigureObjectList) {
        List<Record> recordList = new ArrayList<>();
        for (DBConfigureObject tmp : dbConfigureObjectList) {
            recordList.add(tmp.getRecord());
        }

        recordDAO.saveAll(recordList);
    }

    /*
    public static void exampleSaveComplexity() {
        RecordDAO recordDAO = new RecordDAOImp();
        Record record = new Record();

        Stopwatch stopwatch = new Stopwatch();
        MemoryUsage memoryUsage = new MemoryUsage();
        memoryUsage.calculateMemoryBeforeProcess();
        stopwatch.startTime();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopwatch.stopTime();
        memoryUsage.calculateMemoryAfterProcess();
        System.out.println(stopwatch.getElapsedTimeString());

        ProcessNameDAO processNameDAO = new ProcessNameDAOImp();
//        ProcessName processName = processNameDAO.getByStringValueFromGivenColumnName("name", EnumProcessName.DATA_STRUCTOR.getName());
        List<ProcessName> processNameList = processNameDAO.getAll();

        Complexity complexityDataStructor = new Complexity();
        ProcessName processNameDataStructor = processNameList.get(0);
        complexityDataStructor.setProcessName(processNameDataStructor);
        complexityDataStructor.setRecord(record);
        complexityDataStructor.setElapsedTime(stopwatch.getElapsedTimeString());
        complexityDataStructor.setMemoryUsage(ReadableFormat.getStringValue(memoryUsage.getUsedMemoryByte()));

        Complexity complexitySortAlgorithm = new Complexity();
        ProcessName processNameSortAlgorithm = processNameList.get(1);
        complexitySortAlgorithm.setProcessName(processNameSortAlgorithm);
        complexitySortAlgorithm.setRecord(record);
        complexitySortAlgorithm.setElapsedTime(stopwatch.getElapsedTimeString());
        complexitySortAlgorithm.setMemoryUsage(ReadableFormat.getStringValue(memoryUsage.getUsedMemoryKB()));


        Complexity complexitySearchAlgorithm = new Complexity();
        ProcessName processNameSearchAlgorithm = processNameList.get(2);
        complexitySearchAlgorithm.setProcessName(processNameSearchAlgorithm);
        complexitySearchAlgorithm.setRecord(record);
        complexitySearchAlgorithm.setElapsedTime(stopwatch.getElapsedTimeString());
        complexitySearchAlgorithm.setMemoryUsage(ReadableFormat.getStringValue(memoryUsage.getUsedMemoryMB()));

        SearchAlgorithmProcess searchAlgorithmProcess = new SearchAlgorithmProcess();
        SearchAlgorithmDAO searchAlgorithmDAO = new SearchAlgorithmDAOImp();
        List<SearchAlgorithm> list = searchAlgorithmDAO.getAll();
        SearchAlgorithm searchAlgorithm = null;

        for (SearchAlgorithm tmp : list) {
            if (tmp.getName().equals(EnumSearchAlgorithm.SEARCH_NODE.getName())) {
                searchAlgorithm = tmp;
                break;
            }
        }
        searchAlgorithmProcess.setRecord(record);
        searchAlgorithmProcess.setSearchAlgorithmId(searchAlgorithm.getId());
        record.setSearchAlgorithmProcess(searchAlgorithmProcess);


//        recordDAO.save(record);
//        ComplexityDAO complexityDAO= new ComplexityDAOImp();
//        complexityDAO.save(complexity);
        List<Complexity> complexityList = new ArrayList<>();
        complexityList.add(complexityDataStructor);
        complexityList.add(complexitySortAlgorithm);
        complexityList.add(complexitySearchAlgorithm);

        record.setComplexityList(complexityList);
        recordDAO.save(record);
                *//*

    EKSIK DAHA ID KISMINI EKLEMEDIM
        Stopwatch stopwatch = new Stopwatch();
        Record record = new Record();
        RecordDAO recordDAO = new RecordDAOImp();
        Complexity complexity = new Complexity();
        ProcessName processName = new ProcessName();
        processName.setName(EnumProcessName.DATA_STRUCTOR.getName());

        DataStructorProcess dsp = new DataStructorProcess();
        dsp.setRecord(record);

        complexity.setRecord(record);

        stopwatch.startTime();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*//*
    }

    public static void exampleSaveWordProcess() {
        RecordDAO recordDAO = new RecordDAOImp();
        Record record = new Record();
        WordProcess wordProcess = new WordProcess();


        WordListDAO wordListDAO = new WordListDAOImp();
        WordList wordListSearch = wordListDAO.getByStringValueFromGivenColumnName("name", "word_50");
        System.out.println(wordListSearch.toString());
        WordList wordListPool = wordListDAO.getByStringValueFromGivenColumnName("name", "word_100");
        System.out.println(wordListPool.toString());

        wordProcess.setTotalWordListId(wordListPool);
        wordProcess.setSearchWordListId(wordListSearch);
        wordProcess.setFoundWord(45);
        wordProcess.setMissingWord(5);
        wordProcess.setRecord(record);
        record.setWordProcess(wordProcess);

        recordDAO.save(record);

//        wordProcess.setTotalWordListId(2);
//        wordProcess.setFoundWord(45);
//        wordProcess.setMissingWord(5);

    }

    public static void exampleSaveSortAlgorithmProcess() {

        RecordDAO dao = new RecordDAOImp();
        List<Record> recordList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            recordList.add(new Record());
        }
        SortAlgorithmProcess sap1 = new SortAlgorithmProcess();
        sap1.setRecord(recordList.get(0));
        sap1.setSortAlgorithmId(5);


        SortAlgorithmProcess sap2 = new SortAlgorithmProcess();
        sap2.setRecord(recordList.get(1));
        sap2.setSortAlgorithmId(3);

        SortAlgorithmProcess sap3 = new SortAlgorithmProcess();
        sap3.setRecord(recordList.get(2));
        sap3.setSortAlgorithmId(2);

        recordList.get(0).setSortAlgorithmProcess(sap1);
        recordList.get(1).setSortAlgorithmProcess(sap2);
        recordList.get(2).setSortAlgorithmProcess(sap3);

        dao.saveAll(recordList);
*//*        Record record = new Record();
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

        dao.save(record);*//*
    }

    public static void exampleSaveSearchAlgorithmProcess() {
        RecordDAO dao = new RecordDAOImp();
        List<Record> recordList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            recordList.add(new Record());
        }
        SearchAlgorithmProcess sap1 = new SearchAlgorithmProcess();
        sap1.setRecord(recordList.get(0));
        sap1.setSearchAlgorithmId(9);


        SearchAlgorithmProcess sap2 = new SearchAlgorithmProcess();
        sap2.setRecord(recordList.get(1));
        sap2.setSearchAlgorithmId(2);

        SearchAlgorithmProcess sap3 = new SearchAlgorithmProcess();
        sap3.setRecord(recordList.get(2));
        sap3.setSearchAlgorithmId(1);

        recordList.get(0).setSearchAlgorithmProcess(sap1);
        recordList.get(1).setSearchAlgorithmProcess(sap2);
        recordList.get(2).setSearchAlgorithmProcess(sap3);

        dao.saveAll(recordList);
     *//*   Record record = new Record();
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

        dao.save(record);*//*
    }


    public static void exampleSaveDataStructorProcess() {
        RecordDAO dao = new RecordDAOImp();
        List<Record> recordList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            recordList.add(new Record());
        }
        DataStructorProcess dsp1 = new DataStructorProcess();
        dsp1.setRecord(recordList.get(0));
        dsp1.setDataStructorId(3);


        DataStructorProcess dsp2 = new DataStructorProcess();
        dsp2.setRecord(recordList.get(1));
        dsp2.setDataStructorId(2);

        DataStructorProcess dsp3 = new DataStructorProcess();
        dsp3.setRecord(recordList.get(2));
        dsp3.setDataStructorId(4);

        recordList.get(0).setDataStructorProcess(dsp1);
        recordList.get(1).setDataStructorProcess(dsp2);
        recordList.get(2).setDataStructorProcess(dsp3);

        dao.saveAll(recordList);
        *//*DataStructorProcessDAO DSPdao = new DataStructorProcessDAOImp();
        RecordDAO dao = new RecordDAOImp();
        DataStructorProcess dsp = new DataStructorProcess();
        dsp.setDataStructorId();*//*
     *//*
//


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

        dao.save(record);*//*
    }

    public static void exampleSaveRecord() {
        RecordDAO recordDAO = new RecordDAOImp();
        *//*List<Record> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Record());
        }
        recordDAO.saveAll(list);*//*
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

    public static void saveAbsentEnumValuesToDB(List<?> enumValue, List<?>
            valueInDB, BaseDAO<Object> baseDAO) {
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

*/
}