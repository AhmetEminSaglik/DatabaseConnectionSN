package org.ahmeteminsaglik.core.exception.dbprocess;


import org.ahmeteminsaglik.core.exception.solution.SolutionMessageDB;

public class DBNullColumnException extends BaseDBNullColumnException {
    public DBNullColumnException(String tableName) {
        super(tableName + " Value is not found. " + SolutionMessageDB.getSolutionNullColumnException());
    }
}
