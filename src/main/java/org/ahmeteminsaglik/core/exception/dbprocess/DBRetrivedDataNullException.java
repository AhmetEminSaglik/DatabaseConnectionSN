package org.ahmeteminsaglik.core.exception.dbprocess;


import org.ahmeteminsaglik.core.exception.solution.SolutionMessageDB;

public class DBRetrivedDataNullException extends BaseDBNullColumnException {
    public DBRetrivedDataNullException(Object tableName) {
        super(tableName + " Value is not found. " + SolutionMessageDB.getSolutionNullColumnException());
    }
}
