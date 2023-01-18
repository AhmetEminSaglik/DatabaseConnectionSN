package org.ahmeteminsaglik.core.utility;

import org.ahmeteminsaglik.entities.db.*;
import org.ahmeteminsaglik.entities.db.Record;

import java.util.List;

public class DBConfigureObject {
    private Record record = new Record();
    private ProcessName processName;
    //    private DataStructor dataStructor;
    private DataStructorProcess dataStructorProcess;
    //    private SortAlgorithm sortAlgorithm;
    private SortAlgorithmProcess sortAlgorithmProcess;
    //    private SearchAlgorithm searchAlgorithm;
    private SearchAlgorithmProcess searchAlgorithmProcess;
    private List<Complexity> complexityList;
    private WordProcess wordProcess;




    /*    --> WordList, Word, WordProcess
     *  Word (wordPool and wordSearchGroup) data will get from Enum.WordTable,
     *  Then this table's name will be get from WordList table
     *  Wordlist.id will set to wordProces
     *  found and missing word number will set to WordProcess variables.
     *  then WordProcess will set to Record.
     *
     *    --> DataStructor, DataStructorProcess
     *  DataStructor will select from EnumDataStructor
     *  then it will get from datastructor DB.
     *  it's id will set to  dataStructorProcess
     *  then dataStructorProcess will set to Record.
     *
     *    --> SortAlgorithm, SortAlgorithmProcess
     *  SortAlgorithm will select from EnumSortAlgorithm
     * then it will get from sortAlgorithm DB.
     * it's id will set to sortAlgorithmProces
     * then sortAlgorithmProcess will set to Record
     *
     *    -->SearchAlgorithm, SearchAlgorithmProcess
     *  SearchAlgorithm will select from EnumSearchAlgorithm
     * then it will get from searchAlgorithm DB.
     * it's id will set to searchAlgorithmProcess
     * then searchAlgorithmProcess will set to Record
     *
     *   -->
     * Create Complexity Object.
     *  ProcessName will select from EnumProcessName
     * then it will get from processName DB
     * it's id will set to  complexity.processName_id
     * time and memory will start then algorithm will work. After algorithm finished, time and memory will stop.
     * Then get these values from time and memory to complexity elapsedTime and usedMemory variable
     * then complexity will set to Record
     *
     *
     * then RecordDao will save the Record.
     *
     * Or above records will keep in a list, and then save all records to db.
     *
     * */

    public ProcessName getProcessName() {
        return processName;
    }

    public void setProcessName(ProcessName processName) {
        this.processName = processName;
    }

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

        for (Complexity tmp : complexityList) {
            tmp.setRecord(record);
        }
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
