package org.ahmeteminsaglik.business.concrete.exception;

import org.ahmeteminsaglik.business.concrete.exception.base.BaseCustomException;
import org.ahmeteminsaglik.enums.EnumProcessName;

public class InvalidProcessNameRequestException extends BaseCustomException {
    public InvalidProcessNameRequestException(EnumProcessName enumProcessName) {
        super(enumProcessName+" is an invalid Process Name for temporary time");
    }
}
