package org.ahmeteminsaglik.dataaccess.concretes.statementinspector;

import lombok.SneakyThrows;
import org.ahmeteminsaglik.exception.TableNameNotFoundException;
import org.hibernate.resource.jdbc.internal.EmptyStatementInspector;

public class WordStatementInspector extends EmptyStatementInspector {
    String tableName;

    public WordStatementInspector(String tableName) {
        this.tableName = tableName;
    }

    @SneakyThrows
    @Override
    public String inspect(String sql) {
        String preparedStatment = super.inspect(sql);
        if (!preparedStatment.contains("word")) {
            throw new TableNameNotFoundException();
        }
        preparedStatment= preparedStatment.replace("word_no_selected_table", tableName);
        System.out.println("preparedStatment : "+preparedStatment);
        System.out.println(this);
        return preparedStatment;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
