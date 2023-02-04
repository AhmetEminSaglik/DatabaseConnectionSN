package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.abstracts.get.api.GetTestResultService;
import org.ahmeteminsaglik.business.abstracts.DataPreparationService;
import org.ahmeteminsaglik.entities.business.DBRecordObject;
import org.ahmeteminsaglik.core.utility.objecttranfer.ObjectTransferUtility;
import org.ahmeteminsaglik.entity.Complexity;

import java.util.ArrayList;
import java.util.List;

public class ObjectTransfer {

    ObjectTransferUtility objectTransferUtility = new ObjectTransferUtility();

    public DBRecordObject transferResultServiceToDBRecordObject(GetTestResultService resultService) {
        DBRecordObject recordObject = new DBRecordObject();
        DataPreparationManagement dataPreparationService = new DataPreparationManagement(recordObject);

        setUsedStructors(dataPreparationService, resultService);
        setWordProcess(dataPreparationService, resultService);
        setComplexityList(dataPreparationService, resultService);

        return recordObject;
    }

    private void setUsedStructors(DataPreparationService dataPreparationService, GetTestResultService resultService) {
        objectTransferUtility.setDataStructorProcessToDataService(dataPreparationService, resultService.getDataStructorProcess());
        objectTransferUtility.setSortAlgorithmToDataService(dataPreparationService, resultService.getSortAlgorithmProcess());
        objectTransferUtility.setSearchAlgorithmToDataService(dataPreparationService, resultService.getSearchAlgorithmProcess());
    }

    private void setWordProcess(DataPreparationService dataPreparationService, GetTestResultService resultService) {
        objectTransferUtility.setWordProcessToDataService(dataPreparationService, resultService.getWordProcessConsept());
    }

    private void setComplexityList(DataPreparationService dataPreparationService, GetTestResultService resultService) {
        List<Complexity> complexityList = new ArrayList<>();

        Complexity dataStructorComplexity = objectTransferUtility.createComplexityByComplexityConsept(resultService.getDataStructorComplexityConcept());
        Complexity sortAlgorithmComplexity = objectTransferUtility.createComplexityByComplexityConsept(resultService.getSortAlgorithmComplexityConcept());
        Complexity searchAlgorithmComplexity = objectTransferUtility.createComplexityByComplexityConsept(resultService.getSearchAlgorithmComplexityConcept());

        complexityList.add(dataStructorComplexity);
        complexityList.add(sortAlgorithmComplexity);
        complexityList.add(searchAlgorithmComplexity);

        objectTransferUtility.setComplexityListToDataService(dataPreparationService, complexityList);
    }

}

