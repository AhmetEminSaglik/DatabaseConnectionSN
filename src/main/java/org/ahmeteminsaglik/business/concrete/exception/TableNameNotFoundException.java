package org.ahmeteminsaglik.business.concrete.exception;

import org.ahmeteminsaglik.business.concrete.exception.base.BaseCustomException;

public class TableNameNotFoundException extends BaseCustomException {
    public TableNameNotFoundException() {
        super("Table name is changed, so WordStatementInspector is not worked properly");
    }
}
