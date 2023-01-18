package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.core.utility.DBConfigureObject;

import java.util.List;

public interface DBSaveProcessAPIService {
    void save(DBConfigureObject dbConfigureObject);
    void save(List<DBConfigureObject> dbConfigureObjectList);
}
