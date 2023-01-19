package org.ahmeteminsaglik.business.concrete;

import jakarta.persistence.EnumType;
import org.ahmeteminsaglik.business.concrete.exception.NullEnumException;
import org.hibernate.type.descriptor.java.EnumJavaType;

public class InputValidation {
    public boolean validate(Class clazz, Enum enumData) {
        if (enumData == null) {
            throw new NullEnumException(clazz);
        }
        return true;
    }
}
