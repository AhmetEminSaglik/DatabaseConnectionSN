package org.ahmeteminsaglik;

import org.ahmeteminsaglik.API.DBSaveProcessAPI;
import org.ahmeteminsaglik.API.DBTableAndColumCreation;
import org.ahmeteminsaglik.API.concretes.DBSaveProcessFundamentalDataSetupManagement;
import org.ahmeteminsaglik.API.concretes.DataManagementFromDB;
import org.ahmeteminsaglik.dataaccess.abstracts.WordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.WordDAOImp;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.db.Complexity;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.entities.db.Word;
import org.ahmeteminsaglik.entities.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        DBTableAndColumCreation DBTableAndColumns = new DBTableAndColumCreation();
//        DBTableAndColumns.createAllTablesAndColumns();
//        System.exit(0);

//        exampleGetAllRequestedWordTableWords();
//        exampleGetAllDataStructor();
//        DataStructor dataStructor= new DataStructor("Test");
//        saveDataStructor(dataStructor);
//        exampleSaveDataToDataStructor();
//        exampleSaveAbsentDataStructor();
//        DBProcessAPI.exampleSaveAbsentSearchAlgorithm();
//        DBProcessAPI.exampleSaveAbsentSortAlgorithm();
//        DBProcessAPI.exampleSaveAbsentWordListTableName();
//        DBProcessAPI.exampleSaveAbsentProcesName();


//        DBProcessAPI.exampleSaveRecord();
//        DBProcessAPI.exampleSaveDataStructorProcess();
//        DBProcessAPI.exampleSaveSortAlgorithmProcess();
//        DBProcessAPI.exampleSaveSearchAlgorithmProcess();

        /// here is created after fixed associations to @OneToOne Record and dataStructor,sort,search process
//        DBProcessAPI.exampleSaveDataStructorProcess();
//        DBProcessAPI.exampleSaveSortAlgorithmProcess();
//        DBProcessAPI.exampleSaveSearchAlgorithmProcess();
//        DBProcessAPI.exampleSaveWordProcess();
//        DBSaveProcessAPI.exampleSaveComplexity();
        DBSaveProcessFundamentalDataSetupManagement setupManagement = new DBSaveProcessFundamentalDataSetupManagement();
        DBSaveProcessAPI dbSaveProcessAPI = new DBSaveProcessAPI();

        setupManagement = fakeProcess(setupManagement);
        dbSaveProcessAPI.save(setupManagement.getDbConfigureObject());


    }

    static DBSaveProcessFundamentalDataSetupManagement fakeProcess(DBSaveProcessFundamentalDataSetupManagement setupManagement) {
        List<String> stringList = new ArrayList<>();

        WordDAO wordDAO = new WordDAOImp();
        EnumWordTable enumWordPool = EnumWordTable.WORD_40_000;
        EnumWordTable enumSearchGroup = EnumWordTable.WORD_3_000;

        List<Word> wordPool = wordDAO.getAll(new WordStatementInspector(enumWordPool));
        List<Word> searchWordGroup = wordDAO.getAll(new WordStatementInspector(enumSearchGroup));

        Stopwatch stopwatch = new Stopwatch();
        MemoryUsage memoryUsage = new MemoryUsage();

        memoryUsage.calculateMemoryBeforeProcess();
        stopwatch.startTime();

        int foundWord = 0;
        int missing = 0;
        for (int i = 0; i < wordPool.size(); i++) {
            for (int j = 0; j < searchWordGroup.size(); j++) {
                if (wordPool.get(i).getWord().equals(searchWordGroup.get(j).getWord())) {
                    System.out.println("word is found : " + wordPool.get(i).getWord());
                    foundWord++;
                    break;
                }
            }
        }
        memoryUsage.calculateMemoryAfterProcess();
        stopwatch.stopTime();

        setupManagement.setFundamentalForWordProcess(enumWordPool, enumSearchGroup, foundWord, (searchWordGroup.size() - foundWord));
        setupManagement.setFundamentalForDataStructorProcess(EnumDataStructor.ARRAYLIST);
        setupManagement.setFundamentalForSortAlgorithmProcess(EnumSortAlgorithm.BUBBLE_SORT);
        setupManagement.setFundamentalForSearchAlgorithmProcess(EnumSearchAlgorithm.LINEAR_SEARCH);

//        List<ComplexityFundamental> complexityList = new ArrayList<>();
        List<Complexity> complexityList = new ArrayList<>();
        Complexity dataStructorComplexity = new Complexity();

        DataManagementFromDB dataManagementFromDB = new DataManagementFromDB();

        ProcessName processNameDataStructor = new ProcessName(EnumProcessName.DATA_STRUCTOR_PROCESS.getName());
        dataStructorComplexity.setProcessNameId(dataManagementFromDB.getProcessName(EnumProcessName.DATA_STRUCTOR_PROCESS).getId());
//        dataStructorComplexity.setProcessNameId(dataManagementFromDB.getProcessName(EnumProcessName.DATA_STRUCTOR_PROCESS).getId());
        dataStructorComplexity.setElapsedTime("00:00:03:123");
        dataStructorComplexity.setMemoryUsage("1234 Fake");

        Complexity sortAlgorithmComplexity = new Complexity();
//        ProcessName processNameSortAlgorithmProcess = new ProcessName(EnumProcessName.SORT_PROCESS.getName());
        sortAlgorithmComplexity.setProcessNameId(dataManagementFromDB.getProcessName(EnumProcessName.SORT_PROCESS).getId());
//        sortAlgorithmComplexity.setProcessNameId(dataManagementFromDB.getProcessName(EnumProcessName.SORT_PROCESS).getId());

        sortAlgorithmComplexity.setElapsedTime("00:00:10:555");
        sortAlgorithmComplexity.setMemoryUsage("22 Fake");

        Complexity searchAlgorithmComplexity = new Complexity();
//        ProcessName processNameSearchAlgorithmProcess = new ProcessName(EnumProcessName.SEARCH_PROCESS.getName());

        searchAlgorithmComplexity.setProcessNameId(dataManagementFromDB.getProcessName(EnumProcessName.SEARCH_PROCESS).getId());
//        searchAlgorithmComplexity.setProcessNameId(dataManagementFromDB.getProcessName(EnumProcessName.SEARCH_PROCESS).getId());
        searchAlgorithmComplexity.setElapsedTime(stopwatch.getElapsedTimeString());
        searchAlgorithmComplexity.setMemoryUsage(ReadableFormat.getStringValue(memoryUsage.getUsedMemoryKB()));

        complexityList.add(dataStructorComplexity);
        complexityList.add(sortAlgorithmComplexity);
        complexityList.add(searchAlgorithmComplexity);

        setupManagement.setFundamentalForComplexity(complexityList);

        return setupManagement;


    }


}