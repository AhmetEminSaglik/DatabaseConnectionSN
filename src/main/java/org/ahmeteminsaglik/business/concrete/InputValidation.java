package org.ahmeteminsaglik.business.concrete;

import org.ahmeteminsaglik.business.concrete.exception.NullEnumException;

public class InputValidation {
    public boolean validate(Class<?> clazz, Enum<?> enumData) throws NullEnumException {
        if (enumData == null) {
            throw new NullEnumException(clazz);
        }
        return true;
    }
}
