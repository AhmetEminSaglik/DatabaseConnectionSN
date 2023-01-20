package org.ahmeteminsaglik.business.concrete.exception;

public class InvalidArrayIndexValueException extends Exception{
    public InvalidArrayIndexValueException(Class<?> clazz) {
        super("To be able to use the array in "+clazz.getSimpleName()+" array length value must be the least 1");
    }
}
