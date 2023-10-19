package org.ahmeteminsaglik.core.utility.objecttranfer;

import org.ahmeteminsaglik.business.abstracts.DBService;
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
import org.ahmeteminsaglik.ReadableFormat;

import java.util.List;

public class ObjectTransferUtility {


    public void setDataStructorProcessToDataService(DataPreparationService dataPreparationService, EnumDataStructor enumDataStructor) {
        dataPreparationService.setDataStructorProcess(enumDataStructor);
    }

    public void setSortAlgorithmToDataService(DataPreparationService dataPreparationService, EnumSortAlgorithm enumSortAlgorithm) {
        dataPreparationService.setSortAlgorithmProcess(enumSortAlgorithm);
    }

    public void setSearchAlgorithmToDataService(DataPreparationService dataPreparationService, EnumSearchAlgorithm enumSearchAlgorithm) {
        dataPreparationService.setSearchAlgorithmProcess(enumSearchAlgorithm);
    }

    public void setWordProcessToDataService(DataPreparationService dataPreparationService, WordProcessConsept wordProcessConsept) {
        dataPreparationService.setWordProcess(
                wordProcessConsept.getUsedTable().getEnumTotalWordList(),
                wordProcessConsept.getUsedTable().getEnumSearchWordList(),
                wordProcessConsept.getStatistics().getFoundWord(),
                wordProcessConsept.getStatistics().getMissingWord()
        );
    }

    public void setComplexityListToDataService(DataPreparationService dataPreparationService, List<Complexity> complexityList) {
        dataPreparationService.setComplexityList(complexityList);
    }

    public Complexity createComplexityByComplexityConsept(ComplexityConsept consept) {
        Complexity complexity = new Complexity();
        setValuesToComplexity(complexity, consept);
        return complexity;
    }

    private ProcessName getProcessNameFromDataBase(EnumProcessName enumProcessName) {
        DBService dbService = new DBManagement();
        return dbService.getProcessName(enumProcessName);
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
        return getStringInReadableFormat(consept.getMemoryUsage().getUsedMemoryKB());
    }

    private String getElapsedTimeInString(ComplexityConsept consept) {
        return consept.getStopwatch().getElapsedTimeString();
    }

    private String getStringInReadableFormat(long value) {
        return ReadableFormat.getStringValue(value);
    }
}
