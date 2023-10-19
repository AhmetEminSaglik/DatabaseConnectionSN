package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.API.concretes.DatabaseConnectionSN;
import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.core.utility.enums.EnumUtility;
import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.enums.*;
import org.ahmeteminsaglik.ReadableFormat;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DBManagementTest {
    DBService dbService;

    @BeforeAll
    static void createTables() {
        DatabaseConnectionSN databaseConnectionSN = new DatabaseConnectionSN();
        databaseConnectionSN.initializeTables();
    }

    @BeforeEach
    public void initialzedObjects() {
        dbService = new DBManagement();
    }

    @Test
    @DisplayName("Requested Word Test")
    void testGetWordsRequestedEnumWordTable() {
        List<Word> wordList = dbService.getWords(EnumWordTable.WORD_1_000);
        int expected = 1_000;
        int actual = wordList.size();
        assertEquals(expected, actual);

        wordList.clear();

        List<EnumWordTable> enumList = EnumUtility.getEnumWordTableList();
        for (EnumWordTable tmp : enumList) {
            wordList = dbService.getWords(tmp);
            String expectedText = tmp.getName();
            String actualText;

            if (wordList.size() == 3_186_983) {
                actualText = "word_all";
            } else {
                actualText = "word_" + ReadableFormat.getStringValue(wordList.size());
            }
            assertEquals(expectedText, actualText);
        }

    }

    @Test
    @DisplayName("Requested WordList Test")
    void testGetWordListWithGivenEnum() {
        /* For one item Static Testing*/
        WordList words = dbService.getWordList(EnumWordTable.WORD_1_000);
        String expected = EnumWordTable.WORD_1_000.getName();
        String actual = words.getName();
        assertEquals(expected, actual);

        /* For All Dynamic Testing*/
        List<EnumWordTable> enumList = EnumUtility.getEnumWordTableList();
        for (EnumWordTable tmp : enumList) {
            WordList object = dbService.getWordList(tmp);
            expected = tmp.getName();
            actual = object.getName();
            assertEquals(expected, actual);
        }

    }

    @Test
    @DisplayName("Requested Total WordList Size Test")
    void testGetAllWordList() {
        List<WordList> list = dbService.getAllWordList();
        List<EnumWordTable> enumList = EnumUtility.getEnumWordTableList();
        int expected = enumList.size();
        int actual = list.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Requested Data Structor Test")
    void testGetDataStructorWithGivenEnum() {
        /* For one item Static Testing*/
        DataStructor dataStructor = dbService.getDataStructor(EnumDataStructor.SEARCHNODE_V1);
        String expected = EnumDataStructor.SEARCHNODE_V1.getName();
        String actual = dataStructor.getName();
        assertEquals(expected, actual);

        /* For All Dynamic Testing*/
        List<EnumDataStructor> enumList = EnumUtility.getEnumDataStructorList();
        for (EnumDataStructor tmp : enumList) {
            DataStructor object = dbService.getDataStructor(tmp);
            expected = tmp.getName();
            actual = object.getName();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Requested Sort Algorithm Test ")
    void testGetSortAlgortihmWithGivenEnum() {
        /* For one item Static Testing*/
        SortAlgorithm sortAlgorithm = dbService.getSortAlgortihm(EnumSortAlgorithm.NO_SORT);
        String expected = EnumSortAlgorithm.NO_SORT.getName();
        String actual = sortAlgorithm.getName();
        assertEquals(expected, actual);

        /* For All Dynamic Testing*/
        List<EnumSortAlgorithm> enumList = EnumUtility.getEnumSortAlgorithmList();
        for (EnumSortAlgorithm tmp : enumList) {
            SortAlgorithm object = dbService.getSortAlgortihm(tmp);
            expected = tmp.getName();
            actual = object.getName();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Requested Search Algorithm Test ")
    void testGetSearchAlgortihmWithGivenEnum() {
        /* For one item Static Testing*/

        SearchAlgorithm searchAlgorithm = dbService.getSearchAlgortihm(EnumSearchAlgorithm.SEARCH_NODE);
        String expected = EnumSearchAlgorithm.SEARCH_NODE.getName();
        String actual = searchAlgorithm.getName();
        assertEquals(expected, actual);

        /* For All Dynamic Testing*/
        List<EnumSearchAlgorithm> enumList = EnumUtility.getEnumSearchAlgorithmList();
        for (EnumSearchAlgorithm tmp : enumList) {
            SearchAlgorithm object = dbService.getSearchAlgortihm(tmp);
            expected = tmp.getName();
            actual = object.getName();
            assertEquals(expected, actual);
        }

    }

    @Test
    @DisplayName("Requested Process Name Test ")
    void testGetProcessNameWithGivenEnum() {
        /* For one item Static Testing*/
        ProcessName processName = dbService.getProcessName(EnumProcessName.SEARCH_PROCESS);
        String expected = EnumProcessName.SEARCH_PROCESS.getName();
        String actual = processName.getName();
        assertEquals(expected, actual);

        /* For All Dynamic Testing*/
        List<EnumProcessName> enumList = EnumUtility.getEnumProcessNameList();
        for (EnumProcessName tmp : enumList) {
            ProcessName object = dbService.getProcessName(tmp);
            expected = tmp.getName();
            actual = object.getName();
            assertEquals(expected, actual);
        }
    }
}