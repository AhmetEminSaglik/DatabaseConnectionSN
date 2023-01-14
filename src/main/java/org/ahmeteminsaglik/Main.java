package org.ahmeteminsaglik;

import org.ahmeteminsaglik.dataaccess.concretes.WordDAOImp;
import org.ahmeteminsaglik.dataaccess.concretes.statementinspector.WordStatementInspector;
import org.ahmeteminsaglik.entities.Word;
import org.ahmeteminsaglik.entities.WordTable;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        exampleGetAllRequestedWordTableWords();
    }

    public static void exampleGetAllRequestedWordTableWords() {
        WordDAOImp wordDAOImp = new WordDAOImp();
        String tableName = WordTable.selectTableName(WordTable.WORD_1_000);
        WordStatementInspector statementInspector = new WordStatementInspector(tableName);
        System.out.println(statementInspector);
        List<Word> wordList = wordDAOImp.getAll(statementInspector);

        wordList.stream().forEach(e -> {
            System.out.println(e);
        });
        System.out.println("wordList.size() : " + wordList.size());

    }

}