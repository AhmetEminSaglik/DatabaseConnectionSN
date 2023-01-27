package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.base.RegisteredObject;
import org.ahmeteminsaglik.core.exception.dbprocess.InvalidRequestDataException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.DataStructor;
import org.ahmeteminsaglik.enums.EnumDataStructor;

public class RegisteredDataStructor extends RegisteredObject<DataStructor> {
    public RegisteredDataStructor(BaseDAO<DataStructor> dao) {
        super(dao);
    }

    @Override
    public DataStructor getByEnum(Enum<?> em) {
        RegisteredObjectDBUtility.fillList(this);
        try {
            for (DataStructor tmp : getList()) {
                if (tmp.getName().equals(EnumDataStructor.valueOf(em.name()).getName()))
                    return tmp;
            }

            throw new InvalidRequestDataException(EnumDataStructor.valueOf(em.name()).getName());
        } catch (InvalidRequestDataException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }

}
