package org.ahmeteminsaglik.entities.custom;

import org.ahmeteminsaglik.entities.db.Word;

import java.util.List;


public class WordPool {
    List<Word> wordList;

    public WordPool() {
    }

    public WordPool(List<Word> wordList) {
        this.wordList = wordList;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }
}
