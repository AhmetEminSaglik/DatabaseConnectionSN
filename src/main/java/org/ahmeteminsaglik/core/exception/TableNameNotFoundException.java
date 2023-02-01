package org.ahmeteminsaglik.core.exception;

import org.ahmeteminsaglik.core.exception.base.BaseCustomException;

public class TableNameNotFoundException extends BaseCustomException {
    public TableNameNotFoundException() {
        super("Table name is changed, so WordStatementInspector is not worked properly");
    }
}
