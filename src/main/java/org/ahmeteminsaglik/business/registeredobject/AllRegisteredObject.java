package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.dataaccess.concretes.imp.DataStructorDAOImp;
import org.ahmeteminsaglik.dataaccess.concretes.imp.ProcessNameDAOImp;

public class AllRegisteredObject {
    private static RegisteredProcessName registeredProcessName = new RegisteredProcessName(new ProcessNameDAOImp());
    private static RegisteredDataStructor registeredDataStructor = new RegisteredDataStructor(new DataStructorDAOImp());

    public static RegisteredProcessName getRegisteredProcessName() {
        return registeredProcessName;
    }

    public static RegisteredDataStructor getRegisteredDataStructor() {
        return registeredDataStructor;
    }
}
