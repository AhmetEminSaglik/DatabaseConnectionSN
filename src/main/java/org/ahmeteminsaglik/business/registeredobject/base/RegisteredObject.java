package org.ahmeteminsaglik.business.registeredobject.base;

import java.util.ArrayList;
import java.util.List;

public abstract class RegisteredObject<T> {
    protected List<T> list = new ArrayList<>();

    public abstract T getByEnum(Enum<?> em);
}
