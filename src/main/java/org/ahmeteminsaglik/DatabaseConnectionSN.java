package org.ahmeteminsaglik;

import org.ahmeteminsaglik.API.abstracts.DBSaveProcessAPIService;
import org.ahmeteminsaglik.core.utility.DBSavingProcessObject;
import org.ahmeteminsaglik.dataaccess.abstracts.RecordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.imp.RecordDAOImp;
import org.ahmeteminsaglik.entities.db.Record;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionSN implements DBSaveProcessAPIService {
    private final RecordDAO recordDAO = new RecordDAOImp();

    @Override
    public void save(DBSavingProcessObject dbSavingProcessObject) {
        recordDAO.save(dbSavingProcessObject.getRecord());
    }

    @Override
    public void save(List<DBSavingProcessObject> dbSavingProcessObjectList) {
        List<Record> recordList = new ArrayList<>();
        for (DBSavingProcessObject tmp : dbSavingProcessObjectList) {
            recordList.add(tmp.getRecord());
        }

        recordDAO.saveAll(recordList);
    }


}