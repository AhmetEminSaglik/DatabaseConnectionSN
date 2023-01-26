package org.ahmeteminsaglik.core.exception.dbprocess;

import org.ahmeteminsaglik.core.exception.solution.SolutionMessageDB;
import org.ahmeteminsaglik.enums.EnumProcessName;

public class InvalidProcessNameRequestException extends BaseDBNullColumnException {
    public InvalidProcessNameRequestException(EnumProcessName enumProcessName) {
        super(enumProcessName + " Value is not found. " + SolutionMessageDB.getSolutionNullColumnException());
    }
}
