package org.ahmeteminsaglik.business.registeredobject.subclass;

import org.ahmeteminsaglik.business.registeredobject.baseclass.RegisteredObject;
import org.ahmeteminsaglik.core.exception.dbprocess.InvalidRequestDataException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.SearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumProcessName;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;

public class RegisteredSearchAlgorithm extends RegisteredObject<SearchAlgorithm> {
    public RegisteredSearchAlgorithm(BaseDAO<SearchAlgorithm> dao) {
        super(dao);
    }

    @Override
    public SearchAlgorithm getByEnum(Enum<?> em) {
        RegisteredObjectDBUtility.fillList(this);

        for (SearchAlgorithm tmp : getList()) {
            if (tmp.getName().equals(EnumSearchAlgorithm.valueOf(em.name()).getName()))
                return tmp;
        }

        String absentValue = EnumSearchAlgorithm.valueOf(em.name()).getName();
        printHintInCaseOfRequestedDataIsNotFound(absentValue);
        return null;
    }
}
