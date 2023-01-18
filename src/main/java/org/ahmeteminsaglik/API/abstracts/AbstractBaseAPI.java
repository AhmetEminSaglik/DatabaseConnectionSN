package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.business.abstracts.DataServiceFromDB;
import org.ahmeteminsaglik.business.concrete.DataManagementFromDB;

public abstract class AbstractBaseAPI {
    protected DataServiceFromDB dataServiceFromDB = new DataManagementFromDB();
}
