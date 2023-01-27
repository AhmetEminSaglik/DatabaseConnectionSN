package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.base.RegisteredObject;
import org.ahmeteminsaglik.core.exception.dbprocess.InvalidRequestDataException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.SortAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;

public class RegisteredSortAlgorithm extends RegisteredObject<SortAlgorithm> {
    public RegisteredSortAlgorithm(BaseDAO<SortAlgorithm> dao) {
        super(dao);
    }

    @Override
    public SortAlgorithm getByEnum(Enum<?> em) {
        RegisteredObjectDBUtility.fillList(this);
        try {
            for (SortAlgorithm tmp : getList()) {
                if (tmp.getName().equals(EnumSortAlgorithm.valueOf(em.name()).getName()))
                    return tmp;
            }

            throw new InvalidRequestDataException(EnumSortAlgorithm.valueOf(em.name()).getName());
        } catch (InvalidRequestDataException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }
}
