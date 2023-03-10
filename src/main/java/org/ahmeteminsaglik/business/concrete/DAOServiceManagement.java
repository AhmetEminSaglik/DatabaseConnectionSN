package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.dataaccess.abstracts.*;
import org.ahmeteminsaglik.dataaccess.concretes.imp.*;

public class DAOServiceManagement {
    private WordDAO wordDAO = new WordDAOImp();
    private  WordListDAO wordListDAO= new WordListDAOImp();
    private DataStructorDAO dataStructorDAO = new DataStructorDAOImp();
    private SortAlgorithmDAO sortAlgorithmDAO = new SortAlgoritmDAOImp();
    private SearchAlgorithmDAO searchAlgorithmDAO = new SearchAlgorithmDAOImp();
    private ProcessNameDAO processNameDAO = new ProcessNameDAOImp();

    public WordDAO getWordDAO() {
        return wordDAO;
    }

    public WordListDAO getWordListDAO() {
        return wordListDAO;
    }

    public DataStructorDAO getDataStructorDAO() {
        return dataStructorDAO;
    }

    public SortAlgorithmDAO getSortAlgorithmDAO() {
        return sortAlgorithmDAO;
    }

    public SearchAlgorithmDAO getSearchAlgorithmDAO() {
        return searchAlgorithmDAO;
    }

    public ProcessNameDAO getProcessNameDAO() {
        return processNameDAO;
    }
}
