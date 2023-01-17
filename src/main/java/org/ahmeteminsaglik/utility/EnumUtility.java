package org.ahmeteminsaglik.utility;

import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.enums.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumUtility {
    public static List<ProcessName> getProcessNameListFromEnum() {
        List<EnumProcessName> enumList = Arrays.asList(EnumProcessName.values());
        List<ProcessName> processNameList = new ArrayList<>();
        enumList.forEach(e -> {
            processNameList.add(new ProcessName(e.getName()));
        });
        return processNameList;
    }

    public static List<DataStructor> getDataStructorListFromEnum() {
        List<EnumDataStructor> enumList = Arrays.asList(EnumDataStructor.values());
        List<DataStructor> dataStructorList = new ArrayList<>();
        enumList.forEach(e -> {
            dataStructorList.add(new DataStructor(e.getName()));
        });
        return dataStructorList;
    }

    public static List<SortAlgorithm> getSortAlgorithmListFromEnum() {
        List<EnumSortAlgorithm> enumList = Arrays.asList(EnumSortAlgorithm.values());
        List<SortAlgorithm> sortAlgorithmList = new ArrayList<>();
        enumList.forEach(e -> {
            sortAlgorithmList.add(new SortAlgorithm(e.getName()));
        });
        return sortAlgorithmList;
    }


    public static List<SearchAlgorithm> getSearchAlgorithmListFromEnum() {
        List<EnumSearchAlgorithm> enumList = Arrays.asList(EnumSearchAlgorithm.values());
        List<SearchAlgorithm> searchAlgorithms = new ArrayList<>();
        enumList.forEach(e -> {
            searchAlgorithms.add(new SearchAlgorithm(e.getName()));
        });
        return searchAlgorithms;
    }

    public static List<WordList> getWordListFromEnum() {
        List<EnumWordTable> enumList = Arrays.asList(EnumWordTable.values());
        List<WordList> wordLists = new ArrayList<>();
        enumList.forEach(e -> {
            wordLists.add(new WordList(e.getName()));
        });
        return wordLists;
    }


}
