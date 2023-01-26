package org.ahmeteminsaglik.business.concrete.exception.base;

public class BaseCustomException extends Exception {
    public BaseCustomException(String msg) {
        super("\n     EXCEPTION : " + msg+"\n");
    }
}
