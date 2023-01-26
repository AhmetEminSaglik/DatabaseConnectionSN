package org.ahmeteminsaglik.business.concrete.exception.dbprocess;


import org.ahmeteminsaglik.business.concrete.exception.solution.SolutionMessageDB;

public class DBNullColumnException extends BaseDBNullColumnException {
    public DBNullColumnException(String tableName) {
        super(tableName + " Value is not found. " + SolutionMessageDB.getSolutionNullColumnException());
    }
}