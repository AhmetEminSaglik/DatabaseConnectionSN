package org.ahmeteminsaglik.API.concretes;

import org.ahmeteminsaglik.API.abstracts.AbstractBaseAPI;
import org.ahmeteminsaglik.API.abstracts.ProcessNameService;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.enums.EnumProcessName;

public class ProcessNameManagement extends AbstractBaseAPI implements ProcessNameService {
    @Override
    public ProcessName getProcessName(EnumProcessName enumProcessName) {
        return dataServiceFromDB.getProcessName(enumProcessName);
    }
}
