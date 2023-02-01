package org.ahmeteminsaglik.core.exception;


import org.ahmeteminsaglik.core.exception.base.BaseCustomException;
import org.ahmeteminsaglik.enums.EnumDataStructor;

public class InvalidDataStructorRequestException extends BaseCustomException {
    public InvalidDataStructorRequestException(EnumDataStructor enumDataStructor) {
        super(enumDataStructor+" is an invalid DataStructor for temporary time");
    }
}
