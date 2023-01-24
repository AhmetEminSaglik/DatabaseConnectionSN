package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.core.utility.DBSavingProcessObject;

import java.util.List;

public interface DBSaveProcessAPIService {
    void save(DBSavingProcessObject dbSavingProcessObject);
    void save(List<DBSavingProcessObject> dbSavingProcessObjectList);
}
