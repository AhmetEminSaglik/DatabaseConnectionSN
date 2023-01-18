package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.business.abstracts.ComplexityService;
import org.ahmeteminsaglik.business.concrete.ComplexityManagement;

public abstract class AbstractComplexityCalculationForAPIService extends AbstractBaseAPI implements ComplexityService {
    ComplexityService complexityService = new ComplexityManagement();

    @Override
    public void startComplexityCalculation() {
        complexityService.startComplexityCalculation();
    }

    @Override
    public void stopComplexityCalculation() {
        complexityService.stopComplexityCalculation();
    }

    @Override
    public String getElapsedTime() {
        return complexityService.getElapsedTime();
    }

    @Override
    public String getUsedMemory() {
        return complexityService.getUsedMemory();
    }
}
