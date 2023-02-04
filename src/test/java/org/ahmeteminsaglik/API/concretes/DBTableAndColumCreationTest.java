package org.ahmeteminsaglik.API.concretes;


import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.core.utility.enums.EnumUtility;
import org.ahmeteminsaglik.entity.*;
import org.ahmeteminsaglik.enums.*;
import org.ahmeteminsaglik.readableformat.ReadableFormat;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBTableAndColumCreationTest {
    DBService dbService;

    @BeforeAll
    static void createTables() {
        DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
        databaseConnectionSN.initializeTables();
    }

    @BeforeEach
    public void initialzeDBManagament() {
        dbService = new DBManagement();
    }


    @Test
    @DisplayName("Data Structor Table Creation Test")
    @Order(1)
    public void testIsDataStructorTableCreatedAndFilledWithAllEnumValues() {
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
    @Order(2)
    public void testIsSortAlgorithmTableCreatedAndFilledWithAllEnumValues() {

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
    @Order(3)
    public void testIsSearchAlgorithmTableCreatedAndFilledWithAllEnumValues() {
        List<EnumSearchAlgorithm> enumList = EnumUtility.getEnumSearchAlgorithmList();
        for (EnumSearchAlgorithm tmp : enumList) {
            SearchAlgorithm object = dbService.getSearchAlgortihm(tmp);
            String expected = tmp.getName();
            String actual = object.getName();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Process Name Table Creation Test")
    @Order(4)
    public void testIsProcessNameTableCreatedAndFilledWithAllEnumValues() {
        List<EnumProcessName> enumList = EnumUtility.getEnumProcessNameList();
        for (EnumProcessName tmp : enumList) {
            ProcessName object = dbService.getProcessName(tmp);//AllRegisteredObject.getRegisteredProcessName().getByEnum(tmp);//dbService.getProcessName(tmp);
            String expected = tmp.getName();
            String actual = object.getName();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("All Word Tables Exist Test")
    @Order(5)
    public void testIsWordListTableExitsWithAllEnumValues() {
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