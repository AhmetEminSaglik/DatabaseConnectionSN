package org.ahmeteminsaglik.business.concrete.exception;

import org.ahmeteminsaglik.business.concrete.exception.base.BaseCustomException;

public class InvalidArrayIndexValueException extends BaseCustomException {
    public InvalidArrayIndexValueException(Class<?> clazz) {
        super("To be able to use the array in " + clazz.getSimpleName() + " array length value must be the least 1");
    }
}
