package org.ahmeteminsaglik.core.utility;

import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.db.Record;

import java.util.List;

public class DBSavingProcessObjectSetting {
    private Record record = new Record();
    private DataStructorProcess dataStructorProcess;
    private SortAlgorithmProcess sortAlgorithmProcess;
    private SearchAlgorithmProcess searchAlgorithmProcess;
    private List<Complexity> complexityList;
    private WordProcess wordProcess;

    public DataStructorProcess getDataStructorProcess() {
        return dataStructorProcess;
    }

    public void setDataStructorProcess(DataStructorProcess dataStructorProcess) {
        this.dataStructorProcess = dataStructorProcess;
        dataStructorProcess.setRecord(record);
        record.setDataStructorProcess(dataStructorProcess);
    }


    public SortAlgorithmProcess getSortAlgorithmProcess() {
        return sortAlgorithmProcess;
    }

    public void setSortAlgorithmProcess(SortAlgorithmProcess sortAlgorithmProcess) {
        this.sortAlgorithmProcess = sortAlgorithmProcess;
        sortAlgorithmProcess.setRecord(record);
        record.setSortAlgorithmProcess(sortAlgorithmProcess);
    }

    public SearchAlgorithmProcess getSearchAlgorithmProcess() {
        return searchAlgorithmProcess;
    }

    public void setSearchAlgorithmProcess(SearchAlgorithmProcess searchAlgorithmProcess) {
        this.searchAlgorithmProcess = searchAlgorithmProcess;
        searchAlgorithmProcess.setRecord(record);
        record.setSearchAlgorithmProcess(searchAlgorithmProcess);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Complexity> getComplexityList() {
        return complexityList;
    }

    public void setComplexityList(List<Complexity> complexityList) {
        this.complexityList = complexityList;
        complexityList.forEach(e -> e.setRecord(record));
        record.setComplexityList(complexityList);
    }

    public WordProcess getWordProcess() {
        return wordProcess;
    }

    public void setWordProcess(WordProcess wordProcess) {
        this.wordProcess = wordProcess;
        wordProcess.setRecord(record);
        record.setWordProcess(wordProcess);
    }
}
