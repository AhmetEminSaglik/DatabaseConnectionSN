package org.ahmeteminsaglik.core.exception.dbprocess;

import org.ahmeteminsaglik.core.exception.solution.SolutionMessageDB;

public class InvalidRequestDataException extends BaseDBNullColumnException {
    public InvalidRequestDataException(String requestedData) {
        super(requestedData + " is not found. " + SolutionMessageDB.getSolutionNullColumnException());
    }
}
