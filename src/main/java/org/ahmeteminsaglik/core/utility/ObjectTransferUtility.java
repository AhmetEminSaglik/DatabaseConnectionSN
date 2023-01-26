package org.ahmeteminsaglik.core.utility;

import org.ahmeteminsaglik.API.concretes.DataPreparationManagement;
import org.ahmeteminsaglik.GetResultService;
import org.ahmeteminsaglik.MemoryUsage;
import org.ahmeteminsaglik.business.abstracts.DataPreparationService;
import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.entities.db.Complexity;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.entity.ComplexityConsept;
import org.ahmeteminsaglik.entity.WordProcessConsept;
import org.ahmeteminsaglik.enums.EnumDataStructor;
import org.ahmeteminsaglik.enums.EnumProcessName;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.readableformat.ReadableFormat;

import java.util.ArrayList;
import java.util.List;

public class ObjectTransferUtility {
    DBManagement dataManagementFromDB = new DBManagement();

    public DBRecordObject transferResultServiceToDBRecordObject(GetResultService resultService) {
        DBRecordObject recordObject = new DBRecordObject();

        DataPreparationManagement dataPreparationService = new DataPreparationManagement(recordObject);

        setDataStructorProcessToDataService(dataPreparationService, resultService.getDataStructorProcess());
        setSortAlgorithmToDataService(dataPreparationService, resultService.getSortAlgorithmProcess());
        setSearchAlgorithmToDataService(dataPreparationService, resultService.getSearchAlgorithmProcess());

        setWordProcessToDataService(dataPreparationService, resultService.getWordProcessConsept());


        List<Complexity> complexityList = new ArrayList<>();

        Complexity dataStructorComplexity = createComplexityGivenComplexityConsept(resultService.getDataStructorComplexityConcept());
        Complexity sortAlgorithmComplexity = createComplexityGivenComplexityConsept(resultService.getSortAlgorithmComplexityConcept());
        Complexity searchAlgorithmComplexity = createComplexityGivenComplexityConsept(resultService.getSearchAlgorithmComplexityConcept());


        complexityList.add(dataStructorComplexity);
        complexityList.add(sortAlgorithmComplexity);
        complexityList.add(searchAlgorithmComplexity);

        setComplexityListToDataService(dataPreparationService, complexityList);


        return recordObject;
    }

    private void setDataStructorProcessToDataService(DataPreparationService dataPreparationService, EnumDataStructor enumDataStructor) {
        dataPreparationService.setDataStructorProcess(enumDataStructor);
    }

    private void setSortAlgorithmToDataService(DataPreparationService dataPreparationService, EnumSortAlgorithm enumSortAlgorithm) {
        dataPreparationService.setSortAlgorithmProcess(enumSortAlgorithm);
    }

    private void setSearchAlgorithmToDataService(DataPreparationService dataPreparationService, EnumSearchAlgorithm enumSearchAlgorithm) {
        dataPreparationService.setSearchAlgorithmProcess(enumSearchAlgorithm);
    }

    private void setWordProcessToDataService(DataPreparationService dataPreparationService, WordProcessConsept wordProcessConsept) {
        dataPreparationService.setWordProcess(
                wordProcessConsept.getEnumTotalWordList(),
                wordProcessConsept.getEnumSearchWordList(),
                wordProcessConsept.getFoundWord(),
                wordProcessConsept.getMissingWord()
        );
    }

    private void setComplexityListToDataService(DataPreparationService dataPreparationService, List<Complexity> complexityList) {
        dataPreparationService.setComplexityList(complexityList);
    }


    private Complexity createComplexityGivenComplexityConsept(ComplexityConsept consept) {
        Complexity complexity = new Complexity();
        setValuesToComplexity(complexity, consept);
        return complexity;
    }

    private ProcessName getProcessNameFromDataBase(EnumProcessName enumProcessName) {
        return dataManagementFromDB.getProcessName(enumProcessName);
    }

    private Complexity setValuesToComplexity(Complexity complexity, ComplexityConsept consept) {
        ProcessName processName = getProcessNameFromDataBase(consept.getEnumProcessName());
        String memoryUsage = getMemoryUsageInString(consept);
        String elapsedTime = getElapsedTimeInString(consept);

        complexity.setProcessName(processName);
        complexity.setMemoryUsage(memoryUsage);
        complexity.setElapsedTime(elapsedTime);

        return complexity;

    }


    private String getMemoryUsageInString(ComplexityConsept consept) {
        return getStringInReadableFormat(consept.getMemoryUsage().getUsedMemoryKB());//ReadableFormat.getStringValue(consept.getMemoryUsage().getUsedMemoryKB());
    }

    private String getElapsedTimeInString(ComplexityConsept consept) {
        return consept.getStopwatch().getElapsedTimeString();//ReadableFormat.getStringValue(consept.getMemoryUsage().getUsedMemoryKB());
    }

    private String getStringInReadableFormat(long value) {
        return ReadableFormat.getStringValue(value);
    }

}
