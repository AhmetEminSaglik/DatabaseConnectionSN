package org.ahmeteminsaglik.business.algorithms;

import org.ahmeteminsaglik.API.abstracts.WordAPIService;
import org.ahmeteminsaglik.API.concretes.WordAPIManagement;
import org.ahmeteminsaglik.entities.db.Word;
import org.ahmeteminsaglik.entities.enums.EnumDataStructor;
import org.ahmeteminsaglik.entities.enums.EnumWordTable;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmProcessManagement {
    private WordAPIService wordAPIService = new WordAPIManagement();

/*    public List<String> getWords(EnumWordTable enumWordTable, EnumDataStructor enumDataStructor) {

        convertWordToString(wordAPIService.getWordList(enumWordTable));

    }*/

    private List<String> convertWordToString(List<Word> wordList) {
        List<String> stringList = new ArrayList<>();
        wordList.forEach(e -> stringList.add(e.getWord()));
        return stringList;
    }

/*
    private ArrayList<String> getDataInArrayList() {


    }
*/
    /*public void sortList(Enum) {
        switch ( enum)
    }*/

}
