package org.ahmeteminsaglik.business.concrete.exception;


import org.ahmeteminsaglik.enums.EnumDataStructor;

public class InvalidDataStructorRequestException extends Exception{
    public InvalidDataStructorRequestException(EnumDataStructor enumDataStructor) {
        super(enumDataStructor+" is an invalid DataStructor for temporary time");
    }
}
