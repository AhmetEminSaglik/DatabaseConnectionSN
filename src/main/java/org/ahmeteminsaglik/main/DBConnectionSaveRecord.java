package org.ahmeteminsaglik.main;

import org.ahmeteminsaglik.business.concrete.InputValidation;
import org.ahmeteminsaglik.business.concrete.exception.NullEnumException;
import org.ahmeteminsaglik.enums.*;

public class DBConnectionSaveRecord {
    private EnumWordTable enumWordTable;
    private EnumDataStructor enumDataStructor;
    private EnumSortAlgorithm enumSortAlgorithm;
    private EnumSearchAlgorithm enumSearchAlgorithm;

    private InputValidation inputValidation = new InputValidation();

    public void saveProcess() {
        try {
            boolean enumValidation = inputValidation.validate(EnumWordTable.class, enumWordTable) &&
                    inputValidation.validate(EnumDataStructor.class, enumDataStructor) &&
                    inputValidation.validate(EnumSortAlgorithm.class, enumSortAlgorithm) &&
                    inputValidation.validate(EnumSearchAlgorithm.class, enumSearchAlgorithm);
            if (enumValidation) {

                System.out.println("Validation is completed");
            }
        } catch (NullEnumException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public DBConnectionSaveRecord setEnumWordTable(EnumWordTable enumWordTable) {
        this.enumWordTable = enumWordTable;
        return this;
    }

    public DBConnectionSaveRecord setEnumDataStructor(EnumDataStructor enumDataStructor) {
        this.enumDataStructor = enumDataStructor;
        return this;
    }

    public DBConnectionSaveRecord setEnumSortAlgorithm(EnumSortAlgorithm enumSortAlgorithm) {
        this.enumSortAlgorithm = enumSortAlgorithm;
        return this;
    }

    public DBConnectionSaveRecord setEnumSearchAlgorithm(EnumSearchAlgorithm enumSearchAlgorithm) {
        this.enumSearchAlgorithm = enumSearchAlgorithm;
        return this;
    }

    public DBConnectionSaveRecord setInputValidation(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
        return this;
    }

    public EnumWordTable getEnumWordTable() {
        return enumWordTable;
    }

    public EnumDataStructor getEnumDataStructor() {
        return enumDataStructor;
    }

    public EnumSortAlgorithm getEnumSortAlgorithm() {
        return enumSortAlgorithm;
    }

    public EnumSearchAlgorithm getEnumSearchAlgorithm() {
        return enumSearchAlgorithm;
    }

    public InputValidation getInputValidation() {
        return inputValidation;
    }
}
