package org.ahmeteminsaglik.business.concrete.exception;

import jakarta.persistence.EnumType;

public class NullEnumException extends NullPointerException {
    public NullEnumException(Class<?> clazz) {
        super(clazz.getSimpleName() + " data is null. Please fill this data --> (example) : set" + clazz.getSimpleName()+"(...)");
    }
}
