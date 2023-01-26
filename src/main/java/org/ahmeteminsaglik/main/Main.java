package org.ahmeteminsaglik.main;

import org.ahmeteminsaglik.*;
import org.ahmeteminsaglik.API.concretes.*;
import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.core.utility.DBRecordObject;
import org.ahmeteminsaglik.core.utility.ObjectTransferUtility;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.enums.*;
import org.ahmeteminsaglik.readableformat.ReadableFormat;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionSN database = new DatabaseConnectionSN();
        database.initializeTables();

        AlgorithmTestResult testResult = getMockAlgorithmResult();

        database.save(testResult);

//        testAPI(testResult);
    }

    static void fakeProcess(int num) {
        System.out.println("fake process started");
        for (int i = 0; i < num; i++) {
            System.out.println("i : " + i);
        }
        System.out.println("fake process is done");
    }

    static AlgorithmTestResult getMockAlgorithmResult() {
        Stopwatch stopwatch = new Stopwatch();
        MemoryUsage memoryUsage = new MemoryUsage();
        stopwatch.startTime();
        memoryUsage.calculateMemoryBeforeProcess();
        fakeProcess(1000);
        stopwatch.stopTime();
        memoryUsage.calculateMemoryAfterProcess();

        SetResultService testResult = new AlgorithmTestResult();
        testResult
                .setDataStructorProcess(EnumDataStructor.ARRAYLIST)
                .setSortAlgorithmProcess(EnumSortAlgorithm.SELECTION_SORT)
                .setSearchAlgorithmProcess(EnumSearchAlgorithm.LINEAR_SEARCH)
                .setWordProcessConsept(EnumWordTable.WORD_1_000, EnumWordTable.WORD_1_500, 500, 1000)
                .setComplexityDataStructor(stopwatch, memoryUsage)
                .setComplexitySortAlgorithm(stopwatch, memoryUsage)
                .setComplexitySearchAlgorithm(stopwatch, memoryUsage);
        return (AlgorithmTestResult) testResult;

    }

    static void testAPI(AlgorithmTestResult algorithmTestResult) {
        GetResultService testResult = algorithmTestResult;

        DBManagement dataManagementFromDB = new DBManagement();
        DBRecordObject recordObject = new DBRecordObject();
        DataPreparationManagement dataPreparationManagement = new DataPreparationManagement(recordObject);
        dataPreparationManagement.setDataStructorProcess(testResult.getDataStructorProcess());
        dataPreparationManagement.setSortAlgorithmProcess(testResult.getSortAlgorithmProcess());
        dataPreparationManagement.setSearchAlgorithmProcess(testResult.getSearchAlgorithmProcess());
        dataPreparationManagement.setWordProcess(testResult.getWordProcessConsept().getEnumTotalWordList(),
                testResult.getWordProcessConsept().getEnumSearchWordList(),
                testResult.getWordProcessConsept().getFoundWord(),
                testResult.getWordProcessConsept().getMissingWord());


        List<Complexity> complexityList = new ArrayList<>();

        Complexity dataStructorComplexity = new Complexity();

        dataStructorComplexity.setProcessName(dataManagementFromDB.getProcessName(testResult.getDataStructorComplexityConcept().getEnumProcessName()));
        dataStructorComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getDataStructorComplexityConcept().getMemoryUsage().getUsedMemoryKB()));
        dataStructorComplexity.setElapsedTime(testResult.getDataStructorComplexityConcept().getStopwatch().getElapsedTimeString());
        // Burda sorun var gibi. Enum Process name'i alinca processname olarak degistirmek gerekiyor belki de dogrudur

        Complexity sortAlgorithmComplexity = new Complexity();
        sortAlgorithmComplexity.setProcessName(dataManagementFromDB.getProcessName(testResult.getSortAlgorithmComplexityConcept().getEnumProcessName()));
        sortAlgorithmComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getSortAlgorithmComplexityConcept().getMemoryUsage().getUsedMemoryKB()));
        sortAlgorithmComplexity.setElapsedTime(testResult.getSortAlgorithmComplexityConcept().getStopwatch().getElapsedTimeString());

        Complexity searchAlgorithmComplexity = new Complexity();
        searchAlgorithmComplexity.setProcessName(dataManagementFromDB.getProcessName(testResult.getSearchAlgorithmComplexityConcept().getEnumProcessName()));
        searchAlgorithmComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getSearchAlgorithmComplexityConcept().getMemoryUsage().getUsedMemoryKB()));
        searchAlgorithmComplexity.setElapsedTime(testResult.getSearchAlgorithmComplexityConcept().getStopwatch().getElapsedTimeString());


        complexityList.add(dataStructorComplexity);
        complexityList.add(sortAlgorithmComplexity);
        complexityList.add(searchAlgorithmComplexity);


//        Complexity dsComplexity = new Complexity();
        /*process names must be retrived from database, otherwise error occurs transparent...*/
//        ProcessName dsProcessName = dataManagementFromDB.getProcessName(testResult.getDataStructorComplexityConcept().getEnumProcessName());
//        System.out.println("AES : " + dsProcessName);
//        dsComplexity.setProcessName(dsProcessName);
//        dsComplexity.setElapsedTime(testResult.getDataStructorComplexityConcept().getStopwatch().getElapsedTimeString());
//        dsComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getDataStructorComplexityConcept().getMemoryUsage().getUsedMemoryKB()));

//        Complexity sortAComplexity = new Complexity();
//        ProcessName sortProcessName = dataManagementFromDB.getProcessName(testResult.getSortAlgorithmComplexityConcept().getEnumProcessName());
//        System.out.println("AES : " + sortProcessName);
//        sortAComplexity.setProcessName(sortProcessName);
//        sortAComplexity.setElapsedTime(testResult.getSortAlgorithmComplexityConcept().getStopwatch().getElapsedTimeString());
//        sortAComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getSortAlgorithmComplexityConcept().getMemoryUsage().getUsedMemoryKB()));

//        Complexity searchAComplexity = new Complexity();
//        ProcessName searchProcessName = dataManagementFromDB.getProcessName(testResult.getSearchAlgorithmComplexityConcept().getEnumProcessName());
//        System.out.println("AES : " + searchProcessName);
//        searchAComplexity.setProcessName(searchProcessName);
//        searchAComplexity.setElapsedTime(testResult.getSearchAlgorithmComplexityConcept().getStopwatch().getElapsedTimeString());
//        searchAComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getSearchAlgorithmComplexityConcept().getMemoryUsage().getUsedMemoryKB()));

//        complexityList.clear();

//        complexityList.add(dsComplexity);
//        complexityList.add(sortAComplexity);
//        complexityList.add(searchAComplexity);


        dataPreparationManagement.setComplexityList(complexityList);
//        DatabaseConnectionSN con = new DatabaseConnectionSN();
//        con.save(dataPreparationManagement.getObjectSetting());

//        System.out.println(dataStructorComplexity);
//        System.out.println(sortAlgorithmComplexity);
//        System.out.println(searchAlgorithmComplexity);

    }
}