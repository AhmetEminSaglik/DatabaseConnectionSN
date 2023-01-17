package org.ahmeteminsaglik.entities;

import org.ahmeteminsaglik.entities.enums.EnumProcessName;

public class ComplexityFundamental {
    private EnumProcessName enumProcessName;
    private String elapsedTime;
    private String memoryUsage;

    public EnumProcessName getEnumProcessName() {
        return enumProcessName;
    }

    public void setEnumProcessName(EnumProcessName enumProcessName) {
        this.enumProcessName = enumProcessName;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(String memoryUsage) {
        this.memoryUsage = memoryUsage;
    }
}
