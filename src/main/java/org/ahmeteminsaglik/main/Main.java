package org.ahmeteminsaglik.main;

import org.ahmeteminsaglik.API.DBSaveProcessAPI;
import org.ahmeteminsaglik.API.DBTableAndColumCreation;
import org.ahmeteminsaglik.API.abstracts.ProcessNameService;
import org.ahmeteminsaglik.API.concretes.*;
import org.ahmeteminsaglik.ReadableFormat;
import org.ahmeteminsaglik.business.abstracts.ComplexityService;
import org.ahmeteminsaglik.business.concrete.ComplexityManagement;
import org.ahmeteminsaglik.dataaccess.concretes.imp.ProcessNameDAOImp;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.enums.*;
import org.ahmeteminsaglik.searchnode.business.concretes.searchnode.SearchNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    /*
     * Todo:
     *  Complexity,*/
    public static void main(String[] args) throws InterruptedException {
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

        DBSaveProcessDataManagement dataManagement = new DBSaveProcessDataManagement();
        DBSaveProcessAPI dbSaveProcessAPI = new DBSaveProcessAPI();

        dataManagement = fakeProcess(dataManagement);
        dbSaveProcessAPI.save(dataManagement.getDbConfigureObject());*/
        testAPI();

    }

    static ComplexityService complexityDataStructor = new ComplexityManagement();
    static ComplexityService complexitySortAlgorithm = new ComplexityManagement();
    static ComplexityService complexitySearchAlgorithm = new ComplexityManagement();

    static void showInfo(String msg) {
        /*String text = msg +
                "\ncomplexityDataStructor : Elapsed Time : " + complexityDataStructor.getElapsedTime() + " MemoryUsage : " + complexityDataStructor.getUsedMemory() +
                "\ncomplexitySortAlgorithm : Elapsed Time : " + complexitySortAlgorithm.getElapsedTime() + " MemoryUsage : " + complexitySortAlgorithm.getUsedMemory() +
                "\ncomplexitySearchAlgorithm : Elapsed Time : " + complexitySearchAlgorithm.getElapsedTime() + " MemoryUsage : " + complexitySearchAlgorithm.getUsedMemory();
        JOptionPane.showMessageDialog(null, text);*/
    }

    static void testAPI() {
        WordAPIManagement wordAPIManagement = new WordAPIManagement();
        ProcessNameManagement processNameManagement = new ProcessNameManagement();
//        showInfo("BASLANGIC");
//        SortAlgorithmAPIService sortAlgorithmAPIService = new SortAlgorithmAPIManagement();
//        SearchAlgorithmAPIService searchAlgorithmAPIService = new SearchAlgorithmAPIManagement();

        List<String> searchWordStringList = new ArrayList<>();
        List<String> wordPoolStringList = new ArrayList<>();

        EnumWordTable enumWordTableWordPool = EnumWordTable.WORD_500_000;
        EnumWordTable enumWordTableSearchWord = EnumWordTable.WORD_1_500;
        ProcessName processNameDataStructor = processNameManagement.getProcessName(EnumProcessName.DATA_STRUCTOR_PROCESS);//new ProcessName();
        ProcessName processNameSortAlgorithm = processNameManagement.getProcessName(EnumProcessName.SORT_PROCESS); //new ProcessName();
        ProcessName processNameSearchAlgorithm = processNameManagement.getProcessName(EnumProcessName.SEARCH_PROCESS);// new ProcessName();

        List<Word> wordPoolList = wordAPIManagement.getWordList(enumWordTableWordPool);
        List<Word> searchWordList = wordAPIManagement.getWordList(enumWordTableSearchWord);
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

        DBSaveProcessDataManagement dataManagement = new DBSaveProcessDataManagement();
        dataManagement.setDataStructorProcess(enumDataStructor);
        dataManagement.setSortAlgorithmProcess(enumSortAlgorithm);
        dataManagement.setSearchAlgorithmProcess(enumSearchAlgorithm);
        dataManagement.setWordProcess(enumWordTableWordPool, enumWordTableSearchWord, foundWordCounter, missingWordNumber);
        dataManagement.setComplexityList(complexityList);
        DBSaveProcessAPI dbProcess = new DBSaveProcessAPI();
        dbProcess.save(dataManagement.getDbConfigureObject());

        System.out.println(dataStructorComplexity);
        System.out.println(sortAlgorithmComplexity);
        System.out.println(searchAlgorithmComplexity);
        showInfo("LAST RESULT");
//        dataStructorAPIService.stopStopwatch();
//        dataStructorAPIService.stopMemoryUsedCalculationAfterProcess();
//        System.out.println(dataStructorAPIService.getElapsedTime());
//        System.out.println(dataStructorAPIService.getUsedMemory());
//        System.out.println("arama yo");
/*


        int foundItem = 0;
        for (Word tmpPool : wordPoolListToBeSearched) {
            for (Word tmpSearchGroup : searchWordList) {
                if (tmpPool.getWord().equals(tmpSearchGroup.getWord())) {
                    foundItem++;
                    break;
                }
            }
        }
*/


    }
/*

    static DBSaveProcessDataManagement fakeProcess(DBSaveProcessDataManagement dataManagement) {
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

        dataManagement.setWordProcess(enumWordPool, enumSearchGroup, foundWord, (searchWordGroup.size() - foundWord));
        dataManagement.setDataStructorProcess(EnumDataStructor.ARRAYLIST);
        dataManagement.setSortAlgorithmProcess(EnumSortAlgorithm.BUBBLE_SORT);
        dataManagement.setSearchAlgorithmProcess(EnumSearchAlgorithm.LINEAR_SEARCH);

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

        dataManagement.setComplexityList(complexityList);

        return dataManagement;


    }

*/

}