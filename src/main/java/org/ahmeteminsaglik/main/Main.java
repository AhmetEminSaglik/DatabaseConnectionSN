package org.ahmeteminsaglik.main;

import org.ahmeteminsaglik.*;
import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.dataaccess.concretes.imp.ProcessNameDAOImp;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.db.Record;
import org.ahmeteminsaglik.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ProcessNameDAOImp test = new ProcessNameDAOImp();
//        System.out.println(test.getAll().size());;
        DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
        databaseConnectionSN.initializeTables();
        DBManagement dbManagement = new DBManagement();
//        ProcessName processName=dbManagement.getProcessName(EnumProcessName.DATA_STRUCTOR_PROCESS);
//        System.out.println(processName);
//        DataStructor dataStructor= dbManagement.getDataStructor(EnumDataStructor.ARRAYLIST);
//        System.out.println(dataStructor);
//        SortAlgorithm  sortAlgorithm =dbManagement.getSortAlgortihm(EnumSortAlgorithm.MERGE_SORT);
//        System.out.println(sortAlgorithm);
        SearchAlgorithm searchAlgorithm = dbManagement.getSearchAlgortihm(EnumSearchAlgorithm.SEARCH_NODE);
        System.out.println(searchAlgorithm);
        System.exit(0);
        /*Todo when values are retrived everytime it get too much time. Instead of everytime I need to store dataStructor, Sort-Search Algorithm, I should store these values in static List
           processName, */
        DatabaseConnectionSN database = new DatabaseConnectionSN();
        database.initializeTables();
        AlgorithmTestResult testResult = getMockAlgorithmResult(100_000, EnumWordTable.WORD_10_000, EnumWordTable.WORD_7_500, 5_500, 2_000);
        database.save(testResult);
    }

    static void fakeProcess(int num) {
        System.out.println("fake process started");
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new Object());
        }
        System.out.println("fake process is done");
    }

    static AlgorithmTestResult getMockAlgorithmResult(int processLoop, EnumWordTable totalWord, EnumWordTable searchWord, int foundWord, int missingWord) {
        Stopwatch stopwatch = new Stopwatch();
        MemoryUsage memoryUsage = new MemoryUsage();
        stopwatch.startTime();
        memoryUsage.calculateMemoryBeforeProcess();
        fakeProcess(processLoop);
        stopwatch.stopTime();
        memoryUsage.calculateMemoryAfterProcess();

        SetResultService testResult = new AlgorithmTestResult();
        testResult
                .setDataStructorProcess(EnumDataStructor.ARRAYLIST)
                .setSortAlgorithmProcess(EnumSortAlgorithm.SELECTION_SORT)
                .setSearchAlgorithmProcess(EnumSearchAlgorithm.LINEAR_SEARCH)
                .setWordProcessConsept(totalWord, searchWord, foundWord, missingWord)
                .setComplexityDataStructor(stopwatch, memoryUsage)
                .setComplexitySortAlgorithm(stopwatch, memoryUsage)
                .setComplexitySearchAlgorithm(stopwatch, memoryUsage);
        return (AlgorithmTestResult) testResult;

    }

}