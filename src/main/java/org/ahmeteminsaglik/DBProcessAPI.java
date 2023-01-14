package org.ahmeteminsaglik;

import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.dataaccess.abstracts.DataStructorDAO;
import org.ahmeteminsaglik.dataaccess.abstracts.WordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.DataStructorDaoImp;
import org.ahmeteminsaglik.dataaccess.concretes.SearchAlgorithmDAOImp;
import org.ahmeteminsaglik.dataaccess.concretes.WordDAOImp;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.db.DataStructor;
import org.ahmeteminsaglik.entities.db.SearchAlgorithm;
import org.ahmeteminsaglik.entities.db.Word;
import org.ahmeteminsaglik.entities.enums.EnumDataStructor;
import org.ahmeteminsaglik.entities.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.entities.enums.EnumWordTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBProcessAPI {

    public static void exampleSaveAbsentSearchAlgorithm() {

        List<EnumSearchAlgorithm> enumList = Arrays.asList(EnumSearchAlgorithm.values());
        List<SearchAlgorithm> searchAlgorithmListFromEnum = new ArrayList<>();
        enumList.forEach(e -> searchAlgorithmListFromEnum.add(new SearchAlgorithm(e.getName())));

        System.out.println("_----------------------------------");
        BaseDAO baseDAO = new SearchAlgorithmDAOImp();
        List<SearchAlgorithm> searchAlgorithmListFromDB = new ArrayList<>();

        List<Object> listDB = exampleGetAllDataFromDBRequestedObject(new SearchAlgorithmDAOImp());
        listDB.forEach(e -> {
            searchAlgorithmListFromDB.add((SearchAlgorithm) e);
        });

        saveAbsentEnumValuesToDB(searchAlgorithmListFromEnum, searchAlgorithmListFromDB, baseDAO);
    }

    public static void saveAbsentEnumValuesToDB(List<?> enumValue, List<?> valueInDB, BaseDAO<Object> baseDAO) {
        for (int i = 0; i < enumValue.size(); i++) {
            boolean dataIsFound = false;
            for (int j = 0; j < valueInDB.size(); j++) {
                if (enumValue.get(i).equals(valueInDB.get(j))) {
                    dataIsFound = true;
                    break;
                }
            }
            if (dataIsFound == false) {
                baseDAO.save(enumValue.get(i));
            }
        }

    }

    public static List<Object> exampleGetAllDataFromDBRequestedObject(BaseDAO<? extends Object> baseDAO) {
        return (List<Object>) baseDAO.getAll();

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
        Object[] dsArr = Arrays.stream(EnumDataStructor.values()).toArray();
        List<DataStructor> list = new ArrayList<>();

        Arrays.stream(dsArr).forEachOrdered(
                e -> {
                    DataStructor dataStructor = new DataStructor(((EnumDataStructor) e).getName());
//                    saveDataStructor(dataStructor);
                    list.add(dataStructor);
                }
        );
        saveAllDataStructor(list);
    }

    public static void exampleSaveAbsentDataStructor() {
        List<DataStructor> listDB = exampleGetAllDataStructor();
        Object[] dsArr = Arrays.stream(EnumDataStructor.values()).toArray();

        for (int i = 0; i < dsArr.length; i++) {
            boolean dataIsFound = false;
            EnumDataStructor enumDSN = ((EnumDataStructor) dsArr[i]);
            for (int j = 0; j < listDB.size(); j++) {

                if (listDB.get(j).getName().equals(enumDSN.getName())) {
                    dataIsFound = true;
                    break;
                }
            }
            if (dataIsFound == false) {
                saveDataStructor(new DataStructor(enumDSN.getName()));
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
