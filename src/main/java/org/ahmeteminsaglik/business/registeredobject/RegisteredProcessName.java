package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.base.RegisteredObject;
import org.ahmeteminsaglik.core.exception.dbprocess.InvalidRequestDataException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.enums.EnumProcessName;

public class RegisteredProcessName extends RegisteredObject<ProcessName> {

    public RegisteredProcessName(BaseDAO<ProcessName> dao) {
        super(dao);
    }

    @Override
    public ProcessName getByEnum(Enum<?> em) {
        RegisteredObjectDBUtility.fillList(this);
        try {
            for (ProcessName tmp : getList()) {
                if (tmp.getName().equals(EnumProcessName.valueOf(em.name()).getName()))
                    return tmp;
            }

            throw new InvalidRequestDataException(EnumProcessName.valueOf(em.name()).getName());
        } catch (InvalidRequestDataException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }
}
