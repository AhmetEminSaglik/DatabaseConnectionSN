package org.ahmeteminsaglik.core.utility;

import org.ahmeteminsaglik.business.concrete.exception.dbprocess.DBNullColumnException;

public class RetrivedObjectValidation {
    public static void printSolutionHintIfRetrivedDataIsNull(Object o, Class<?> clazz) {
        try {
            if (o == null) {
                throw new DBNullColumnException(clazz.getSimpleName());
            }
        } catch (DBNullColumnException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
