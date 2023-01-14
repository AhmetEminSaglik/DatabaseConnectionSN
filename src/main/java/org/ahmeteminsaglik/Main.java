package org.ahmeteminsaglik;

import org.ahmeteminsaglik.dataaccess.abstracts.DataStructorDAO;
import org.ahmeteminsaglik.dataaccess.abstracts.WordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.DataStructorDaoImp;
import org.ahmeteminsaglik.dataaccess.concretes.WordDAOImp;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.db.DataStructor;
import org.ahmeteminsaglik.entities.db.Word;
import org.ahmeteminsaglik.entities.enums.EnumDataStructorName;
import org.ahmeteminsaglik.entities.enums.EnumWordTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        exampleGetAllRequestedWordTableWords();
//        exampleGetAllDataStructor();
//        DataStructor dataStructor= new DataStructor("Test");
//        saveDataStructor(dataStructor);
//        exampleSaveDataToDataStructor();
        exampleSaveAbsentDataStructor();
    }

    public static void exampleGetAllRequestedWordTableWords() {
        WordDAO wordDAO = new WordDAOImp();
        String tableName = EnumWordTable.selectTableName(EnumWordTable.WORD_1_000);
        WordStatementInspector statementInspector = new WordStatementInspector(tableName);
        System.out.println(statementInspector);
        List<Word> wordList = wordDAO.getAll(statementInspector);

        wordList.stream().forEach(e -> {
            System.out.println(e);
        });
        System.out.println("wordList.size() : " + wordList.size());
    }

    public static List<DataStructor> exampleGetAllDataStructor() {
        DataStructorDAO dataStructorDAO = new DataStructorDaoImp();
        List<DataStructor> list = dataStructorDAO.getAll();
        return list;
    }

    public static void exampleSaveDataToDataStructor() {
        Object[] dsArr = Arrays.stream(EnumDataStructorName.values()).toArray();
        List<DataStructor> list = new ArrayList<>();

        Arrays.stream(dsArr).forEachOrdered(
                e -> {
                    DataStructor dataStructor = new DataStructor(((EnumDataStructorName) e).getName());
//                    saveDataStructor(dataStructor);
                    list.add(dataStructor);
                }
        );
        saveAllDataStructor(list);
    }

    public static void exampleSaveAbsentDataStructor() {
        List<DataStructor> listDB = exampleGetAllDataStructor();
        Object[] dsArr = Arrays.stream(EnumDataStructorName.values()).toArray();

        for (int i = 0; i < dsArr.length; i++) {
            EnumDataStructorName enumDSN = ((EnumDataStructorName) dsArr[i]);
            for (int j = 0; j < listDB.size(); j++) {

                if (listDB.get(j).getName().equals(enumDSN.getName())) {
                    break;
                }
                if (j == listDB.size() - 1) {
                    saveDataStructor(new DataStructor(enumDSN.getName()));
                    break;
                }

            }
        }


    }

    public static void saveDataStructor(DataStructor dataStructor) {

        DataStructorDAO dao = new DataStructorDaoImp();
        dao.save(dataStructor);

    }

    public static void saveAllDataStructor(List<DataStructor> dataStructorList) {
        DataStructorDAO dao = new DataStructorDaoImp();
        dao.saveAll(dataStructorList);
    }


}