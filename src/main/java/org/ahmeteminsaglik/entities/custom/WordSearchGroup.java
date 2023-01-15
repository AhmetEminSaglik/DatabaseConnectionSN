package org.ahmeteminsaglik.entities.custom;

import org.ahmeteminsaglik.entities.db.Word;

import java.util.List;

public class WordSearchGroup {
    List<Word> wordList;

    public WordSearchGroup() {
    }

    public WordSearchGroup(List<Word> wordList) {
        this.wordList = wordList;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }
}
