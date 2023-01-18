package org.ahmeteminsaglik.API;

import org.ahmeteminsaglik.API.abstracts.DBSaveProcessAPIService;
import org.ahmeteminsaglik.dataaccess.abstracts.*;
import org.ahmeteminsaglik.dataaccess.concretes.imp.RecordDAOImp;
import org.ahmeteminsaglik.entities.db.Record;
import org.ahmeteminsaglik.core.utility.DBConfigureObject;

import java.util.ArrayList;
import java.util.List;

public class DBSaveProcessAPI implements DBSaveProcessAPIService {
    private final RecordDAO recordDAO = new RecordDAOImp();

    @Override
    public void save(DBConfigureObject dbConfigureObject) {
        recordDAO.save(dbConfigureObject.getRecord());
    }

    @Override
    public void save(List<DBConfigureObject> dbConfigureObjectList) {
        List<Record> recordList = new ArrayList<>();
        for (DBConfigureObject tmp : dbConfigureObjectList) {
            recordList.add(tmp.getRecord());
        }

        recordDAO.saveAll(recordList);
    }


}
