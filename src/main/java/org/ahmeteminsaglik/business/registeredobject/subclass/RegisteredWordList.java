package org.ahmeteminsaglik.business.registeredobject.subclass;

import org.ahmeteminsaglik.business.registeredobject.baseclass.RegisteredObject;
import org.ahmeteminsaglik.core.exception.dbprocess.InvalidRequestDataException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.WordList;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.enums.EnumWordTable;

public class RegisteredWordList extends RegisteredObject<WordList> {
    public RegisteredWordList(BaseDAO<WordList> dao) {
        super(dao);
    }

    @Override
    public WordList getByEnum(Enum<?> em) {
        RegisteredObjectDBUtility.fillList(this);

        for (WordList tmp : getList()) {
            if (tmp.getName().equals(EnumWordTable.valueOf(em.name()).getName()))
                return tmp;
        }
        String absentValue = EnumWordTable.valueOf(em.name()).getName();
        printHintInCaseOfRequestedDataIsNotFound(absentValue);
        return null;
    }
}
