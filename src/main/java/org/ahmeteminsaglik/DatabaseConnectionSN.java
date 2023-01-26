package org.ahmeteminsaglik;

import org.ahmeteminsaglik.API.concretes.DBTableAndColumCreation;
import org.ahmeteminsaglik.API.abstracts.DBSaveAPIService;
import org.ahmeteminsaglik.API.abstracts.InitializeTablesAPIService;
import org.ahmeteminsaglik.core.utility.DBRecordObject;
import org.ahmeteminsaglik.business.concrete.ObjectTransfer;
import org.ahmeteminsaglik.dataaccess.abstracts.RecordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.imp.RecordDAOImp;
import org.ahmeteminsaglik.entities.db.Record;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionSN implements DBSaveAPIService, InitializeTablesAPIService {
    private final RecordDAO recordDAO = new RecordDAOImp();
    private ObjectTransfer objectTransfer = new ObjectTransfer();

    @Override
    public void initializeTables() {
        DBTableAndColumCreation DBTableAndColumns = new DBTableAndColumCreation();
        DBTableAndColumns.createAllTablesAndColumns();
    }

    @Override
    public void save(GetResultService resultService) {
        Record record = getRecordFromResultService(resultService);
        recordDAO.save(record);
    }

    @Override
    public void save(List<GetResultService> resultServiceList) {
        List<Record> recordList = new ArrayList<>();
        for (GetResultService tmp : resultServiceList) {
            recordList.add(getRecordFromResultService(tmp));
        }
        recordDAO.saveAll(recordList);
    }

    private Record getRecordFromResultService(GetResultService resultService) {
        DBRecordObject recordObject = objectTransfer.transferResultServiceToDBRecordObject(resultService);
        return recordObject.getRecord();
    }


}