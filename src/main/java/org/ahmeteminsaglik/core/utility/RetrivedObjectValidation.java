package org.ahmeteminsaglik.core.utility;

import org.ahmeteminsaglik.core.exception.dbprocess.DBRetrivedDataNullException;

public class RetrivedObjectValidation {
    public static void printSolutionHintIfRetrivedDataIsNull(Object o, Class<?> clazz) {
        try {
            if (o == null) {
                throw new DBRetrivedDataNullException(clazz.getSimpleName());
            }
        } catch (DBRetrivedDataNullException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
