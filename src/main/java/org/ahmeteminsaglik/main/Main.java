package org.ahmeteminsaglik.main;

import org.ahmeteminsaglik.API.concretes.*;
import org.ahmeteminsaglik.DatabaseConnectionSN;
import org.ahmeteminsaglik.TestResult;
import org.ahmeteminsaglik.business.concrete.ComplexityManagement;
import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.enums.*;
import org.ahmeteminsaglik.readableformat.ReadableFormat;
import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    /*
     * Todo:
     *  Complexity,*/
    public static void main(String[] args) {

//        DBService dbTest = new DBManagement();
//        List<Word> words_50 = dbTest.getWords(EnumWordTable.WORD_50);
//        List<Word> words_1_000 = dbTest.getWords(EnumWordTable.WORD_1_000);
//
//
//        System.out.println("Words Expected 50 Actual : " + words_50.size());
//        System.out.println("Words Expected 1000 Actual : " + words_1_000.size());
//        System.exit(0);
      /*  DBConnectionSaveRecord connectionSaveRecord = new DBConnectionSaveRecord();
        connectionSaveRecord.setEnumWordTable(EnumWordTable.WORD_50)
                .setEnumDataStructor(EnumDataStructor.ARRAYLIST)
                .setEnumSortAlgorithm(EnumSortAlgorithm.BUBBLE_SORT)
                .setEnumSearchAlgorithm(EnumSearchAlgorithm.LINEAR_SEARCH)
                .saveProcess();
        System.exit(0);*/

//        DBTableAndColumCreation DBTableAndColumns = new DBTableAndColumCreation();
//        DBTableAndColumns.createAllTablesAndColumns();
//        System.exit(0);
/*

        DataPreparation dataManagement = new DataPreparation();
        DBSaveProcessAPI dbSaveProcessAPI = new DBSaveProcessAPI();

        dataManagement = fakeProcess(dataManagement);
        dbSaveProcessAPI.save(dataManagement.getDbConfigureObject());*/

//        DBManagement db = new DBManagement();
//        String msg = "GET : word_no_selected_table yerine word_50 yapinca hata vermedi. Bide bunun save olanini denemeliyim";
//        List<Word> words = db.getWords(EnumWordTable.WORD_1_000);
//        System.out.println(words.size());
//        JOptionPane.showMessageDialog(null, msg);


//        DatabaseConnectionSN database= new DatabaseConnectionSN();
//        database.initializeTables();

        testAPI();

    }

    static ComplexityManagement complexityDataStructor = new ComplexityManagement();
    static ComplexityManagement complexitySortAlgorithm = new ComplexityManagement();
    static ComplexityManagement complexitySearchAlgorithm = new ComplexityManagement();

    static void showInfo(String msg) {
        /*String text = msg +
                "\ncomplexityDataStructor : Elapsed Time : " + complexityDataStructor.getElapsedTime() + " MemoryUsage : " + complexityDataStructor.getUsedMemory() +
                "\ncomplexitySortAlgorithm : Elapsed Time : " + complexitySortAlgorithm.getElapsedTime() + " MemoryUsage : " + complexitySortAlgorithm.getUsedMemory() +
                "\ncomplexitySearchAlgorithm : Elapsed Time : " + complexitySearchAlgorithm.getElapsedTime() + " MemoryUsage : " + complexitySearchAlgorithm.getUsedMemory();
        JOptionPane.showMessageDialog(null, text);*/
    }

    static void testAPI() {
        DBManagement dataManagementFromDB = new DBManagement();
//        WordAPIManagement wordAPIManagement = new WordAPIManagement();
        ProcessNameManagement processNameManagement = new ProcessNameManagement();
//        showInfo("BASLANGIC");
//        SortAlgorithmAPIService sortAlgorithmAPIService = new SortAlgorithmAPIManagement();
//        SearchAlgorithmAPIService searchAlgorithmAPIService = new SearchAlgorithmAPIManagement();

        List<String> searchWordStringList = new ArrayList<>();
        List<String> wordPoolStringList = new ArrayList<>();

        EnumWordTable enumWordTableWordPool = EnumWordTable.WORD_250;
        EnumWordTable enumWordTableSearchWord = EnumWordTable.WORD_1_000;
        ProcessName processNameDataStructor = processNameManagement.getProcessName(EnumProcessName.DATA_STRUCTOR_PROCESS);//new ProcessName();
        ProcessName processNameSortAlgorithm = processNameManagement.getProcessName(EnumProcessName.SORT_PROCESS); //new ProcessName();
        ProcessName processNameSearchAlgorithm = processNameManagement.getProcessName(EnumProcessName.SEARCH_PROCESS);// new ProcessName();

        List<Word> wordPoolList = dataManagementFromDB.getWords(enumWordTableWordPool);
        List<Word> searchWordList = dataManagementFromDB.getWords(enumWordTableSearchWord);
        searchWordList.forEach(e -> searchWordStringList.add(e.getWord()));
        SearchNode searchNode = new SearchNode();

        EnumDataStructor enumDataStructor = EnumDataStructor.ARRAYLIST;
        EnumSortAlgorithm enumSortAlgorithm = EnumSortAlgorithm.TIM_SORT;
        EnumSearchAlgorithm enumSearchAlgorithm = EnumSearchAlgorithm.LINEAR_SEARCH;
        complexityDataStructor.startComplexityCalculation();
        wordPoolList.forEach(e -> wordPoolStringList.add(e.getWord()));
        complexityDataStructor.stopComplexityCalculation();
        showInfo("AFTER DATA Structor ");

//        SortAlgorithm sortAlgorithm = sortAlgorithmAPIService.getDataStructorName(EnumSortAlgorithm.MERGE_SORT);
        complexitySortAlgorithm.startComplexityCalculation();
        Collections.sort(wordPoolStringList);
        complexitySortAlgorithm.stopComplexityCalculation();
//        JOptionPane.showMessageDialog(null, "complexitySortAlgorithm : Elapsed Time : " + complexityDataStructor.getElapsedTime() +
//                " MemoryUsage : " + complexityDataStructor.getUsedMemory());
        showInfo("AFTER SORT ALGORITHM");
//        SearchAlgorithm searchAlgorithm = searchAlgorithmAPIService.getDataStructorName(EnumSearchAlgorithm.LINEAR_SEARCH);
        complexitySearchAlgorithm.startComplexityCalculation();

        int foundWordCounter = 0;
        int missingWordNumber = 0;
        /*for (String tmp : searchWordStringList) {
            Result result = searchNode.search(tmp);
            if (result.isSuccess()) {
                foundWordCounter++;
            }
        }*/
        for (String tmpWordPool : wordPoolStringList) {
            for (String tmpSearchWord : searchWordStringList) {
                if (tmpWordPool.equals(tmpSearchWord)) {
                    foundWordCounter++;
                    System.out.println("found counter : " + ReadableFormat.getStringValue(foundWordCounter));
                }
            }
        }
        missingWordNumber = searchWordStringList.size() - foundWordCounter;
        complexitySearchAlgorithm.stopComplexityCalculation();
        showInfo("AFTER SEARCH ALGORITHM");
//        JOptionPane.showMessageDialog(null, "complexitySearchAlgorithm : Elapsed Time : " + complexityDataStructor.getElapsedTime() +
//                " MemoryUsage : " + complexityDataStructor.getUsedMemory());
        List<Complexity> complexityList = new ArrayList<>();

//        processNameDataStructor.setName(EnumProcessName.DATA_STRUCTOR_PROCESS.getName());
        Complexity dataStructorComplexity = new Complexity();

        dataStructorComplexity.setProcessName(processNameDataStructor);
        dataStructorComplexity.setElapsedTime(complexityDataStructor.getElapsedTime());
        dataStructorComplexity.setMemoryUsage(complexityDataStructor.getUsedMemory());
        dataStructorComplexity.setProcessName(processNameDataStructor);

        Complexity sortAlgorithmComplexity = new Complexity();
        sortAlgorithmComplexity.setElapsedTime(complexitySortAlgorithm.getElapsedTime());
        sortAlgorithmComplexity.setMemoryUsage(complexitySortAlgorithm.getUsedMemory());
        sortAlgorithmComplexity.setProcessName(processNameSortAlgorithm);

        Complexity searchAlgorithmComplexity = new Complexity();
        searchAlgorithmComplexity.setElapsedTime(complexitySearchAlgorithm.getElapsedTime());
        searchAlgorithmComplexity.setMemoryUsage(complexitySearchAlgorithm.getUsedMemory());
        searchAlgorithmComplexity.setProcessName(processNameSearchAlgorithm);

        complexityList.add(dataStructorComplexity);
        complexityList.add(sortAlgorithmComplexity);
        complexityList.add(searchAlgorithmComplexity);


        /*TODO burada kaldim. bazi bilgileri disaridan almam icin ek bir library seklinde hazirlamaliyim*/
        TestResult testResult = new TestResult();

        testResult
                .setDataStructorProcess(EnumDataStructor.ARRAYLIST)
                .setSortAlgorithmProcess(EnumSortAlgorithm.SELECTION_SORT)
                .setSearchAlgorithmProcess(EnumSearchAlgorithm.LINEAR_SEARCH)
                .setWordProcessConsept(enumWordTableWordPool, enumWordTableSearchWord, foundWordCounter, missingWordNumber)
                .setComplexityDataStructor(complexityDataStructor.getStopwatch(), complexityDataStructor.getMemoryUsage())
                .setComplexitySortAlgorithm(complexitySortAlgorithm.getStopwatch(), complexitySortAlgorithm.getMemoryUsage())
                .setComplexitySearchAlgorithm(complexitySearchAlgorithm.getStopwatch(), complexitySearchAlgorithm.getMemoryUsage());


        DataPreparation dataPreparation = new DataPreparation();
        dataPreparation.setDataStructorProcess(testResult.getDataStructorProcess());
        dataPreparation.setSortAlgorithmProcess(testResult.getSortAlgorithmProcess());
        dataPreparation.setSearchAlgorithmProcess(testResult.getSearchAlgorithmProcess());
        dataPreparation.setWordProcess(testResult.getWordProcessConsept().getEnumTotalWordList(),
                testResult.getWordProcessConsept().getEnumSearchWordList(),
                testResult.getWordProcessConsept().getFoundWord(),
                testResult.getWordProcessConsept().getMissingWord());


        Complexity dsComplexity = new Complexity();
        /*process names must be retrived from database, otherwise error occurs transparent...*/
        ProcessName dsProcessName= processNameManagement.getProcessName(testResult.getDataStructorComplexityConcept().getEnumProcessName());
        System.out.println("AES : "+dsProcessName);
        dsComplexity.setProcessName(dsProcessName);
        dsComplexity.setElapsedTime(testResult.getDataStructorComplexityConcept().getStopwatch().getElapsedTimeString());
        dsComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getDataStructorComplexityConcept().getMemoryUsage().getUsedMemoryKB()));

        Complexity sortAComplexity = new Complexity();
        ProcessName sortProcessName= processNameManagement.getProcessName(testResult.getSortAlgorithmComplexityConcept().getEnumProcessName());
        System.out.println("AES : "+sortProcessName);
        sortAComplexity.setProcessName(sortProcessName);
        sortAComplexity.setElapsedTime(testResult.getSortAlgorithmComplexityConcept().getStopwatch().getElapsedTimeString());
        sortAComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getSortAlgorithmComplexityConcept().getMemoryUsage().getUsedMemoryKB()));

        Complexity searchAComplexity = new Complexity();
        ProcessName searchProcessName= processNameManagement.getProcessName(testResult.getSearchAlgorithmComplexityConcept().getEnumProcessName());
        System.out.println("AES : "+searchProcessName);
        searchAComplexity.setProcessName(searchProcessName);
        searchAComplexity.setElapsedTime(testResult.getSearchAlgorithmComplexityConcept().getStopwatch().getElapsedTimeString());
        searchAComplexity.setMemoryUsage(ReadableFormat.getStringValue(testResult.getSearchAlgorithmComplexityConcept().getMemoryUsage().getUsedMemoryKB()));

        complexityList.clear();

        complexityList.add(dsComplexity);
        complexityList.add(sortAComplexity);
        complexityList.add(searchAComplexity);


        dataPreparation.setComplexityList(complexityList);
        DatabaseConnectionSN con = new DatabaseConnectionSN();
        con.save(dataPreparation.getObjectSetting());

        System.out.println(dataStructorComplexity);
        System.out.println(sortAlgorithmComplexity);
        System.out.println(searchAlgorithmComplexity);
        showInfo("LAST RESULT");

    }
}