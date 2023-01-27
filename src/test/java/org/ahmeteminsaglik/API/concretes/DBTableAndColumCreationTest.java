package org.ahmeteminsaglik.API.concretes;


import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.core.utility.enums.EnumUtility;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.enums.*;
import org.ahmeteminsaglik.readableformat.ReadableFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class DBTableAndColumCreationTest {

    DBTableAndColumCreation tableAndColumCreation;
    DBService dbService;

    @BeforeEach
    public void initialzedObjects() {
        tableAndColumCreation = new DBTableAndColumCreation();
        dbService = new DBManagement();
    }

    @Test
    @DisplayName("Process Name Table Creation Test")
    public void testIsProcessNameTableCreatedAndFilledWithAllEnumValues() {
        tableAndColumCreation.createAllTablesAndColumns();

        List<EnumProcessName> enumList = EnumUtility.getEnumProcessNameList();
        for (EnumProcessName tmp : enumList) {
            ProcessName object = dbService.getProcessName(tmp);//AllRegisteredObjects.getRegisteredProcessName().getByEnum(tmp);//dbService.getProcessName(tmp);
            String expected = tmp.getName();
            String actual = object.getName();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Data Structor Table Creation Test")
    public void testIsDataStructorTableCreatedAndFilledWithAllEnumValues() {
        tableAndColumCreation.createAllTablesAndColumns();

        List<EnumDataStructor> enumList = EnumUtility.getEnumDataStructorList();
        for (EnumDataStructor tmp : enumList) {
            DataStructor object = dbService.getDataStructor(tmp);
            String expected = tmp.getName();
            String actual = object.getName();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Sort Algorithm Table Creation Test")
    public void testIsSortAlgorithmTableCreatedAndFilledWithAllEnumValues() {
        tableAndColumCreation.createAllTablesAndColumns();

        List<EnumSortAlgorithm> enumList = EnumUtility.getEnumSortAlgorithmList();
        for (EnumSortAlgorithm tmp : enumList) {
            SortAlgorithm object = dbService.getSortAlgortihm(tmp);
            String expected = tmp.getName();
            String actual = object.getName();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Search Algorithm Table Creation Test")
    public void testIsSearchAlgorithmTableCreatedAndFilledWithAllEnumValues() {
        tableAndColumCreation.createAllTablesAndColumns();
        List<EnumSearchAlgorithm> enumList = EnumUtility.getEnumSearchAlgorithmList();
        for (EnumSearchAlgorithm tmp : enumList) {
            SearchAlgorithm object = dbService.getSearchAlgortihm(tmp);
            String expected = tmp.getName();
            String actual = object.getName();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("WordList Table Exist Test")
    public void testIsWordListTableTableExitsWithAllEnumValues() {
        tableAndColumCreation.createAllTablesAndColumns();
        List<EnumWordTable> enumList = EnumUtility.getEnumWordTableList();
        for (EnumWordTable tmp : enumList) {
            List<Word> wordList = dbService.getWords(tmp);
            String expected = tmp.getName();
            String actual;

            if (wordList.size() == 3_186_983) {
                actual = "word_all";
            } else {
                actual = "word_" + ReadableFormat.getStringValue(wordList.size());
            }
            assertEquals(expected, actual);
        }
    }
}