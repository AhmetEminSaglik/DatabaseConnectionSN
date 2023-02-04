package org.ahmeteminsaglik.business.registeredobject.subclass;

import org.ahmeteminsaglik.business.registeredobject.baseclass.RegisteredObject;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entity.DataStructor;
import org.ahmeteminsaglik.enums.EnumDataStructor;

public class RegisteredDataStructor extends RegisteredObject<DataStructor> {
    public RegisteredDataStructor(BaseDAO<DataStructor> dao) {
        super(dao);
    }

    @Override
    public DataStructor getByEnum(Enum<?> em) {
        for (DataStructor tmp : getList()) {
            if (tmp.getName().equals(EnumDataStructor.valueOf(em.name()).getName()))
                return tmp;
        }
        String absentValue = EnumDataStructor.valueOf(em.name()).getName();
        printHintInCaseOfRequestedDataIsNotFound(absentValue);
        return null;
    }

}
