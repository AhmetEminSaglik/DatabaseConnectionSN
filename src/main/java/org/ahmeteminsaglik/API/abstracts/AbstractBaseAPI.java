package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.business.abstracts.DBService;
import org.ahmeteminsaglik.business.concrete.DBManagement;

public abstract class AbstractBaseAPI {
    protected DBService dataServiceFromDB = new DBManagement();
}
