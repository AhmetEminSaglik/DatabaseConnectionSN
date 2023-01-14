package org.ahmeteminsaglik.exception;

public class TableNameNotFoundException extends Exception {

    public TableNameNotFoundException() {
        super("Table name is changed, so WordStatementInspector is not worked properly");
    }
}
