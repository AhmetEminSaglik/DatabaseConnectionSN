package org.ahmeteminsaglik.business.algorithms;

import org.ahmeteminsaglik.API.abstracts.WordAPIService;
import org.ahmeteminsaglik.API.concretes.WordAPIManagement;
import org.ahmeteminsaglik.entities.enums.EnumDataStructor;
import org.ahmeteminsaglik.entities.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.entities.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.entities.enums.EnumWordTable;

import java.util.List;

public class AlgorithmProcess {
    private EnumWordTable enumWordTable;
    private EnumDataStructor enumDataStructor;
    private EnumSortAlgorithm enumSortAlgorithm;
    private EnumSearchAlgorithm enumSearchAlgorithm;

    private AlgorithmProcessManagement algoritmManagement = new AlgorithmProcessManagement();

    public AlgorithmProcess(EnumWordTable enumWordTable, EnumDataStructor enumDataStructor, EnumSortAlgorithm enumSortAlgorithm, EnumSearchAlgorithm enumSearchAlgorithm) {
        this.enumWordTable = enumWordTable;
        this.enumDataStructor = enumDataStructor;
        this.enumSortAlgorithm = enumSortAlgorithm;
        this.enumSearchAlgorithm = enumSearchAlgorithm;
    }

    public void start() {
//        List<String> wordList = algoritmManagement.getWords(enumWordTable);
//        algoritmManagement.sortList();

    }

}
