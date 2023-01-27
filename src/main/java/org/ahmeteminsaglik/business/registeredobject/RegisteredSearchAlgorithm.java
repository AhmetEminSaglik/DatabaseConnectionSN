package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.base.RegisteredObject;
import org.ahmeteminsaglik.core.exception.dbprocess.InvalidRequestDataException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.SearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;

public class RegisteredSearchAlgorithm extends RegisteredObject<SearchAlgorithm> {
    public RegisteredSearchAlgorithm(BaseDAO<SearchAlgorithm> dao) {
        super(dao);
    }

    @Override
    public SearchAlgorithm getByEnum(Enum<?> em) {
        RegisteredObjectDBUtility.fillList(this);
        try {
            for (SearchAlgorithm tmp : getList()) {
                if (tmp.getName().equals(EnumSearchAlgorithm.valueOf(em.name()).getName()))
                    return tmp;
            }

            throw new InvalidRequestDataException(EnumSearchAlgorithm.valueOf(em.name()).getName());
        } catch (InvalidRequestDataException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }
}
