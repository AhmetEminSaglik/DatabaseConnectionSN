package org.ahmeteminsaglik.business.registeredobject.subclass;

import org.ahmeteminsaglik.business.registeredobject.baseclass.RegisteredObject;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entity.SortAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;

public class RegisteredSortAlgorithm extends RegisteredObject<SortAlgorithm> {
    public RegisteredSortAlgorithm(BaseDAO<SortAlgorithm> dao) {
        super(dao);
    }

    @Override
    public SortAlgorithm getByEnum(Enum<?> em) {
        for (SortAlgorithm tmp : getList()) {
            if (tmp.getName().equals(EnumSortAlgorithm.valueOf(em.name()).getName()))
                return tmp;
        }
        String absentValue = EnumSortAlgorithm.valueOf(em.name()).getName();
        printHintInCaseOfRequestedDataIsNotFound(absentValue);
        return null;
    }
}
