package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.base.RegisteredObject;
import org.ahmeteminsaglik.core.exception.dbprocess.InvalidRequestDataException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.dataaccess.abstracts.BaseDAO;
import org.ahmeteminsaglik.entities.db.WordList;
import org.ahmeteminsaglik.enums.EnumWordTable;

public class RegisteredWordList extends RegisteredObject<WordList> {
    public RegisteredWordList(BaseDAO<WordList> dao) {
        super(dao);
    }

    @Override
    public WordList getByEnum(Enum<?> em) {
        RegisteredObjectDBUtility.fillList(this);
        try {
            for (WordList tmp : getList()) {
                if (tmp.getName().equals(EnumWordTable.valueOf(em.name()).getName()))
                    return tmp;
            }
            throw new InvalidRequestDataException(EnumWordTable.valueOf(em.name()).getName());
        } catch (InvalidRequestDataException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }
}
