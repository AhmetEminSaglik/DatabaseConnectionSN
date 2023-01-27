package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.dataaccess.concretes.imp.DataStructorDAOImp;
import org.ahmeteminsaglik.dataaccess.concretes.imp.ProcessNameDAOImp;
import org.ahmeteminsaglik.dataaccess.concretes.imp.SortAlgoritmDAOImp;

public class AllRegisteredObject {
    private static RegisteredProcessName registeredProcessName = new RegisteredProcessName(new ProcessNameDAOImp());
    private static RegisteredDataStructor registeredDataStructor = new RegisteredDataStructor(new DataStructorDAOImp());
    private static RegisteredSortAlgorithm registeredSortAlgorithm = new RegisteredSortAlgorithm(new SortAlgoritmDAOImp());


    public static RegisteredProcessName getProcessname() {
        return registeredProcessName;
    }

    public static RegisteredDataStructor getDataStructor() {
        return registeredDataStructor;
    }

    public static RegisteredSortAlgorithm getSortAlgorithm() {
        return registeredSortAlgorithm;
    }
}
