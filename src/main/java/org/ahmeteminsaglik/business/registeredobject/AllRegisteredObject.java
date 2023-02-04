package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.subclass.*;
import org.ahmeteminsaglik.dataaccess.concretes.imp.*;

public class AllRegisteredObject {
    private static RegisteredDataStructor registeredDataStructor = new RegisteredDataStructor(new DataStructorDAOImp());
    private static RegisteredSortAlgorithm registeredSortAlgorithm = new RegisteredSortAlgorithm(new SortAlgoritmDAOImp());
    private static RegisteredSearchAlgorithm registeredSearchAlgorithm = new RegisteredSearchAlgorithm(new SearchAlgorithmDAOImp());
    private static RegisteredProcessName registeredProcessName = new RegisteredProcessName(new ProcessNameDAOImp());
    private static RegisteredWordList registeredWordList = new RegisteredWordList(new WordListDAOImp());

    public static RegisteredDataStructor getDataStructor() {
        return registeredDataStructor;
    }

    public static RegisteredSortAlgorithm getSortAlgorithm() {
        return registeredSortAlgorithm;
    }

    public static RegisteredSearchAlgorithm getSearchAlgorithm() {
        return registeredSearchAlgorithm;
    }

    public static RegisteredProcessName getProcessName() {
        return registeredProcessName;
    }

    public static RegisteredWordList getWordList() {
        return registeredWordList;
    }
}
