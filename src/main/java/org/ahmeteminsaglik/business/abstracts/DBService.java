package org.ahmeteminsaglik.business.abstracts;

import org.ahmeteminsaglik.entity.*;
import org.ahmeteminsaglik.enums.*;

import java.util.List;


public interface DBService {
    public List<Word> getWords(EnumWordTable enumWordTable);

    public WordList getWordList(EnumWordTable enumWordTable);
    public  List<WordList> getAllWordList();

    public DataStructor getDataStructor(EnumDataStructor enumDataStructor);

    public SortAlgorithm getSortAlgortihm(EnumSortAlgorithm enumSortAlgorithm);

    public SearchAlgorithm getSearchAlgortihm(EnumSearchAlgorithm enumSearchAlgorithm);

    public ProcessName getProcessName(EnumProcessName enumProcessName);

}
