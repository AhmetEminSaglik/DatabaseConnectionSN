package org.ahmeteminsaglik.dataaccess.concretes.statementinspector;

import lombok.SneakyThrows;
import org.ahmeteminsaglik.enums.*;
import org.hibernate.resource.jdbc.internal.EmptyStatementInspector;

public class WordStatementInspector extends EmptyStatementInspector {
    private String newTableName;
    private final String defaultTableName = "word_50";

    public WordStatementInspector(EnumWordTable enumWordTable) {
        this.newTableName = enumWordTable.getName();
    }

    @SneakyThrows
    @Override
    public String inspect(String sql) {
        String preparedStatment = super.inspect(sql);
        preparedStatment = preparedStatment.replace(defaultTableName, newTableName);
        return preparedStatment;
    }

    public String getnewTableName() {
        return newTableName;
    }

    public void setNewTableName(String newTableName) {
        this.newTableName = newTableName;
    }
}
