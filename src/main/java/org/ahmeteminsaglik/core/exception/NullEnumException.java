package org.ahmeteminsaglik.core.exception;

import org.ahmeteminsaglik.core.exception.base.BaseCustomException;

public class NullEnumException extends BaseCustomException {
    public NullEnumException(Class<?> clazz) {
        super(clazz.getSimpleName() + " data is null. Please fill this data --> (example) : set" + clazz.getSimpleName()+"(...)");
    }
}
