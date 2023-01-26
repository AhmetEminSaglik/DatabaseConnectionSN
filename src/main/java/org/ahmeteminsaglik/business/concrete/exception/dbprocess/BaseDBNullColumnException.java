package org.ahmeteminsaglik.business.concrete.exception.dbprocess;

import org.ahmeteminsaglik.business.concrete.exception.base.BaseCustomException;

public class BaseDBNullColumnException extends BaseCustomException {
    public BaseDBNullColumnException(String msg) {
        super(msg);
    }
}
