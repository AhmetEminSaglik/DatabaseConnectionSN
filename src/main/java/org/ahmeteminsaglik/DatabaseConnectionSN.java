package org.ahmeteminsaglik;

import org.ahmeteminsaglik.API.concretes.DBTableAndColumCreation;
import org.ahmeteminsaglik.API.abstracts.DBSaveAPIService;
import org.ahmeteminsaglik.API.abstracts.InitializeTablesService;
import org.ahmeteminsaglik.core.utility.DBRecordObject;
import org.ahmeteminsaglik.business.concrete.ObjectTransfer;
import org.ahmeteminsaglik.dataaccess.abstracts.RecordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.imp.RecordDAOImp;
import org.ahmeteminsaglik.entities.db.Record;

import java.util.List;

public class DatabaseConnectionSN implements DBSaveAPIService, InitializeTablesService {
    private final RecordDAO recordDAO = new RecordDAOImp();
    private ObjectTransfer objectTransfer = new ObjectTransfer();

    @Override
    public void save(GetResultService testResult) {

        DBRecordObject recordObject = objectTransfer.transferResultServiceToDBRecordObject(testResult);
        Record record = recordObject.getRecord();
        recordDAO.save(record);
    }

    @Override
    public void save(List<GetResultService> testResultList) {
   /*     List<Record> recordList = new ArrayList<>();
        for (DBSavingProcessObject tmp : dbSavingProcessObjectList) {
            recordList.add(tmp.getRecord());
        }
        recordDAO.saveAll(recordList);*/
    }


    @Override
    public void initializeTables() {
        DBTableAndColumCreation DBTableAndColumns = new DBTableAndColumCreation();
        DBTableAndColumns.createAllTablesAndColumns();
    }
}