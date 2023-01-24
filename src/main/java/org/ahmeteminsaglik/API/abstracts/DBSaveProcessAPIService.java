package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.core.utility.DBSavingProcessObjectSetting;

import java.util.List;

public interface DBSaveProcessAPIService {
    void save(DBSavingProcessObjectSetting dbSavingProcessObjectSetting);
    void save(List<DBSavingProcessObjectSetting> dbSavingProcessObjectSettingList);
}
