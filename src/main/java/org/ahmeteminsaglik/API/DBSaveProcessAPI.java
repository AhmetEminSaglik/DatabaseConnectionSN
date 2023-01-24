package org.ahmeteminsaglik.API;

import org.ahmeteminsaglik.API.abstracts.DBSaveProcessAPIService;
import org.ahmeteminsaglik.dataaccess.abstracts.*;
import org.ahmeteminsaglik.dataaccess.concretes.imp.RecordDAOImp;
import org.ahmeteminsaglik.entities.db.Record;
import org.ahmeteminsaglik.core.utility.DBSavingProcessObjectSetting;

import java.util.ArrayList;
import java.util.List;

public class DBSaveProcessAPI implements DBSaveProcessAPIService {
    private final RecordDAO recordDAO = new RecordDAOImp();

    @Override
    public void save(DBSavingProcessObjectSetting dbSavingProcessObjectSetting) {
        recordDAO.save(dbSavingProcessObjectSetting.getRecord());
    }

    @Override
    public void save(List<DBSavingProcessObjectSetting> dbSavingProcessObjectSettingList) {
        List<Record> recordList = new ArrayList<>();
        for (DBSavingProcessObjectSetting tmp : dbSavingProcessObjectSettingList) {
            recordList.add(tmp.getRecord());
        }

        recordDAO.saveAll(recordList);
    }


}
