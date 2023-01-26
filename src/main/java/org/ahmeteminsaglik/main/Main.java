package org.ahmeteminsaglik.main;

import org.ahmeteminsaglik.*;
import org.ahmeteminsaglik.entities.db.Record;
import org.ahmeteminsaglik.enums.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionSN database = new DatabaseConnectionSN();
        database.initializeTables();
        AlgorithmTestResult testResult = getMockAlgorithmResult(100_000, EnumWordTable.WORD_10_000, EnumWordTable.WORD_7_500, 5_500, 2_000);
        database.save(testResult);
    }

    static void fakeProcess(int num) {
        System.out.println("fake process started");
        List<Record> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("i : " + i);
            list.add(new Record());
            System.out.println("olusturulan list : " + list.get(i).toString());
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