package org.ahmeteminsaglik.business.abstracts;

public interface ComplexityService {

    void startComplexityCalculation();
    void stopComplexityCalculation();

//    void startStopwatch();
//    void stopStopwatch();

//    void startMemoryUsedCalculationBeforeProcess();
//    void stopMemoryUsedCalculationAfterProcess();

    String getElapsedTime();

    String getUsedMemory();
}
