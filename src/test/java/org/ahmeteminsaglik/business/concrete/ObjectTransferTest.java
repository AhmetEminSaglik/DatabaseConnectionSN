package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.*;
import org.ahmeteminsaglik.API.concretes.DatabaseConnectionSN;
import org.ahmeteminsaglik.abstracts.get.api.GetTestResultService;
import org.ahmeteminsaglik.abstracts.set.api.SetTestResultService;
import org.ahmeteminsaglik.dataaccess.abstracts.RecordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.imp.RecordDAOImp;
import org.ahmeteminsaglik.entities.db.Record;
import org.ahmeteminsaglik.entity.WordProcessStatistics;
import org.ahmeteminsaglik.entity.WordProcessUsedTable;
import org.ahmeteminsaglik.enums.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectTransferTest {
    DatabaseConnectionSN dbConnection = new DatabaseConnectionSN();
    RecordDAO recordDAO = new RecordDAOImp();

    @Test
    @DisplayName("Save Database Fake Data")
    void testMockData() {
        List<Record> recordList = recordDAO.getAll();
        int oldRecordSize = recordList.size();

        GetTestResultService testResult = mockTestResult(1_000);

        List<GetTestResultService> testResultlist = new ArrayList<>();
        GetTestResultService testResult1 = mockTestResult(5_000);
        GetTestResultService testResult2 = mockTestResult(10_000);
        GetTestResultService testResult3 = mockTestResult(15_000);
        testResultlist.add(testResult1);
        testResultlist.add(testResult2);
        testResultlist.add(testResult3);

        dbConnection.save(testResult);
        dbConnection.save(testResultlist);

        recordList = recordDAO.getAll();
        int newRecordSize = recordList.size();

        int expected = oldRecordSize + 4;
        int actual = newRecordSize;
        assertEquals(expected, actual);


    }

    static TestAlgorithmResult mockTestResult(int processNumber) {
        /* create Fake Algorithm Test Result */
        Stopwatch stopwatch = new Stopwatch();
        MemoryUsage memoryUsage = new MemoryUsage();
        stopwatch.startTime();
        memoryUsage.calculateMemoryBeforeProcess();
        fakeProcess(processNumber);

        stopwatch.stopTime();
        memoryUsage.calculateMemoryAfterProcess();

        SetTestResultService testResult = new TestAlgorithmResult();
        testResult
                .setDataStructorProcess(EnumDataStructor.SEARCHNODE_V2)
                .setSortAlgorithmProcess(EnumSortAlgorithm.NO_SORT)
                .setSearchAlgorithmProcess(EnumSearchAlgorithm.SEARCH_NODE)
                .setWordProcessUsedTable(new WordProcessUsedTable(EnumWordTable.WORD_10_000,EnumWordTable.WORD_5_000))
                .setWordProcessStatistic(new WordProcessStatistics(4_725,275))
                .setComplexityConseptDataStructor(stopwatch, memoryUsage)
                .setComplexityConseptSortAlgorithm(stopwatch, memoryUsage)
                .setComplexityConseptSearchAlgorithm(stopwatch, memoryUsage);

        return (TestAlgorithmResult) testResult;
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

}