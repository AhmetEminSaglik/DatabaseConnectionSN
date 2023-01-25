package org.ahmeteminsaglik;

import org.ahmeteminsaglik.API.DBTableAndColumCreation;
import org.ahmeteminsaglik.API.abstracts.DBSaveProcessAPIService;
import org.ahmeteminsaglik.API.abstracts.InitializeTablesService;
import org.ahmeteminsaglik.core.utility.DBSavingProcessObject;
import org.ahmeteminsaglik.dataaccess.abstracts.RecordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.imp.RecordDAOImp;
import org.ahmeteminsaglik.entities.db.Record;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionSN implements DBSaveProcessAPIService, InitializeTablesService {
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


    @Override
    public void initializeTables() {
        DBTableAndColumCreation DBTableAndColumns = new DBTableAndColumCreation();
        DBTableAndColumns.createAllTablesAndColumns();
    }
}