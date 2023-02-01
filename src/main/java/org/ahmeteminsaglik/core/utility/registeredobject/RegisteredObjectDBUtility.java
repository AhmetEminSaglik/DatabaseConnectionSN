package org.ahmeteminsaglik.core.utility.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.baseclass.RegisteredObject;

public class RegisteredObjectDBUtility {

    public static synchronized <T> void fillList(RegisteredObject<T> registeredObject) {
        if (registeredObject.getList() == null) {
            registeredObject.setList(registeredObject.getDao().getAll());
        }
    }
}
