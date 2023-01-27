package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.dataaccess.concretes.imp.ProcessNameDAOImp;

public class AllRegisteredObject {
    private static RegisteredProcessName registeredProcessName = new RegisteredProcessName(new ProcessNameDAOImp());

    public static RegisteredProcessName getRegisteredProcessName() {
        return registeredProcessName;
    }
}
