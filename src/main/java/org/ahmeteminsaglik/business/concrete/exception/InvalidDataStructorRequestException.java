package org.ahmeteminsaglik.business.concrete.exception;


import org.ahmeteminsaglik.business.concrete.exception.base.BaseCustomException;
import org.ahmeteminsaglik.enums.EnumDataStructor;

public class InvalidDataStructorRequestException extends BaseCustomException {
    public InvalidDataStructorRequestException(EnumDataStructor enumDataStructor) {
        super(enumDataStructor+" is an invalid DataStructor for temporary time");
    }
}
