package org.ahmeteminsaglik.core.exception.dbprocess;

import org.ahmeteminsaglik.core.exception.base.BaseCustomException;

public class BaseDBNullColumnException extends BaseCustomException {
    public BaseDBNullColumnException(String msg) {
        super(msg);
    }
}
