package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.entities.enums.EnumProcessName;

public interface ProcessNameService {
    ProcessName getProcessName(EnumProcessName enumProcessName);
}
