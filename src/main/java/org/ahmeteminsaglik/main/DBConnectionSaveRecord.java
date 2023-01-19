package org.ahmeteminsaglik.main;

import jakarta.persistence.EnumType;
import org.ahmeteminsaglik.business.concrete.InputValidation;
import org.ahmeteminsaglik.entities.enums.EnumDataStructor;
import org.ahmeteminsaglik.entities.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.entities.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.entities.enums.EnumWordTable;

import java.util.List;

public class DBConnectionSaveRecord {
    private EnumWordTable enumWordTable;
    private EnumDataStructor enumDataStructor;
    private EnumSortAlgorithm enumSortAlgorithm;
    private EnumSearchAlgorithm enumSearchAlgorithm;

    private InputValidation inputValidation = new InputValidation();

    public void saveProcess() {
        boolean enumValidation = inputValidation.validate(EnumWordTable.class, enumWordTable) &&
                inputValidation.validate(EnumDataStructor.class, enumDataStructor) &&
                inputValidation.validate(EnumSortAlgorithm.class, enumSortAlgorithm) &&
                inputValidation.validate(EnumSearchAlgorithm.class, enumSearchAlgorithm);
        if (enumValidation) {
            System.out.println("Validation is completed");
        }
    }

    public void saveProcess(List<DBConnectionSaveRecord> list) {
    }

    public EnumWordTable getEnumWordTable() {
        return enumWordTable;
    }

    public void setEnumWordTable(EnumWordTable enumWordTable) {
        this.enumWordTable = enumWordTable;
    }

    public EnumDataStructor getEnumDataStructor() {
        return enumDataStructor;
    }

    public void setEnumDataStructor(EnumDataStructor enumDataStructor) {
        this.enumDataStructor = enumDataStructor;
    }

    public EnumSortAlgorithm getEnumSortAlgorithm() {
        return enumSortAlgorithm;
    }

    public void setEnumSortAlgorithm(EnumSortAlgorithm enumSortAlgorithm) {
        this.enumSortAlgorithm = enumSortAlgorithm;
    }

    public EnumSearchAlgorithm getEnumSearchAlgorithm() {
        return enumSearchAlgorithm;
    }

    public void setEnumSearchAlgorithm(EnumSearchAlgorithm enumSearchAlgorithm) {
        this.enumSearchAlgorithm = enumSearchAlgorithm;
    }

    public InputValidation getInputValidation() {
        return inputValidation;
    }

    public void setInputValidation(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }
}
