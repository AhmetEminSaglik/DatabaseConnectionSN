package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.ImproperUseOfStopwatchException;
import org.ahmeteminsaglik.business.abstracts.ComplexityService;
import org.ahmeteminsaglik.MemoryUsage;
import org.ahmeteminsaglik.ReadableFormat;
import org.ahmeteminsaglik.Stopwatch;

public class ComplexityManagement implements ComplexityService {
    protected Stopwatch stopwatch;
    protected MemoryUsage memoryUsage;

    public ComplexityManagement() {
        stopwatch = new Stopwatch();
        memoryUsage = new MemoryUsage();
    }

    @Override
    public void startComplexityCalculation() {
        stopwatch.startTime();
        memoryUsage.calculateMemoryBeforeProcess();
    }

    @Override
    public void stopComplexityCalculation() {
        stopwatch.stopTime();
        memoryUsage.calculateMemoryAfterProcess();
    }

    @Override
    public String getElapsedTime() {
        try {
            return stopwatch.getElapsedTimeString();
        } catch (ImproperUseOfStopwatchException e) {
            System.err.println(e.getMessage());
        }
        return "ImproperUseOfStopwatchException is thrown";
    }

    @Override
    public String getUsedMemory() {
        return ReadableFormat.getStringValue(memoryUsage.getUsedMemoryKB());
    }

    public Stopwatch getStopwatch() {
        return stopwatch;
    }

    public void setStopwatch(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    public MemoryUsage getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(MemoryUsage memoryUsage) {
        this.memoryUsage = memoryUsage;
    }
}
