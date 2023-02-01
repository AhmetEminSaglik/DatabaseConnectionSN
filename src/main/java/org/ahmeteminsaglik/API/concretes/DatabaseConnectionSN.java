package org.ahmeteminsaglik.API.concretes;

import org.ahmeteminsaglik.API.abstracts.DBSaveAPIService;
import org.ahmeteminsaglik.API.abstracts.DBWordAPIService;
import org.ahmeteminsaglik.API.abstracts.InitializeTablesAPIService;
import org.ahmeteminsaglik.abstracts.get.api.GetTestResultService;
import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.entities.business.DBRecordObject;
import org.ahmeteminsaglik.business.concrete.ObjectTransfer;
import org.ahmeteminsaglik.dataaccess.abstracts.RecordDAO;
import org.ahmeteminsaglik.dataaccess.concretes.imp.RecordDAOImp;
import org.ahmeteminsaglik.entities.db.Record;
import org.ahmeteminsaglik.entities.db.Word;
import org.ahmeteminsaglik.enums.EnumWordTable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionSN implements DBSaveAPIService, InitializeTablesAPIService, DBWordAPIService {
    private static boolean DBTablesAreInitilazed = false;
    private final RecordDAO recordDAO = new RecordDAOImp();
    private ObjectTransfer objectTransfer = new ObjectTransfer();

    private DBService dbService = new DBManagement();

    public DatabaseConnectionSN() {
        if (DBTablesAreInitilazed == false) {
            initializeTables();
            DBTablesAreInitilazed = true;
        }
    }

    @Override
    public void initializeTables() {
        DBTableAndColumCreation DBTableAndColumns = new DBTableAndColumCreation();
        DBTableAndColumns.createAllTablesAndColumns();
    }

    @Override
    public void save(GetTestResultService resultService) {
        Record record = getRecordFromResultService(resultService);
        recordDAO.save(record);
    }

    @Override
    public void save(List<GetTestResultService> resultServiceList) {
        List<Record> recordList = new ArrayList<>();
        for (GetTestResultService tmp : resultServiceList) {
            recordList.add(getRecordFromResultService(tmp));
        }
        recordDAO.saveAll(recordList);
    }

    private Record getRecordFromResultService(GetTestResultService resultService) {
        DBRecordObject recordObject = objectTransfer.transferResultServiceToDBRecordObject(resultService);
        return recordObject.getRecord();
    }

    @Override
    public List<Word> getWords(EnumWordTable enumWordTable) {
        return dbService.getWords(enumWordTable);
    }
}