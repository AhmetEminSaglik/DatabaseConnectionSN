package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.enums.*;

import java.util.List;

public interface DataServiceFromDB {
    public WordList getWordList(EnumWordTable enumWordTable);
    public DataStructor getDataStructor(EnumDataStructor enumDataStructor);
    public SortAlgorithm getSortAlgortihm(EnumSortAlgorithm enumSortAlgorithm);
    public SearchAlgorithm getSearchAlgortihm(EnumSearchAlgorithm enumSearchAlgorithm);
    public ProcessName getProcessName(EnumProcessName enumProcessName);

}
