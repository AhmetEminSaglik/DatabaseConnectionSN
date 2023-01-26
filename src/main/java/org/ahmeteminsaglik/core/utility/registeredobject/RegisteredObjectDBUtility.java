package org.ahmeteminsaglik.core.utility.registeredobject;

import org.ahmeteminsaglik.business.concrete.DBManagement;
import org.ahmeteminsaglik.business.concrete.exception.InvalidProcessNameRequestException;
import org.ahmeteminsaglik.dataaccess.abstracts.ProcessNameDAO;
import org.ahmeteminsaglik.dataaccess.concretes.imp.ProcessNameDAOImp;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.enums.EnumProcessName;

import java.util.ArrayList;
import java.util.List;

public class RegisteredObjectDBUtility {
    private static DBManagement dataManagementFromDB = new DBManagement();

    private static List<ProcessName> processNameList = null;

    public static ProcessName getRequestedProcessNameByGivenEnumProcessName(EnumProcessName enumProcessName) {
        fillProcessNameList();

        try {
            for (ProcessName processName : processNameList) {
                if (processName.getName().equals(enumProcessName.getName())) {
                    return processName;
                }
            }
            throw new InvalidProcessNameRequestException(enumProcessName);

        } catch (InvalidProcessNameRequestException exception) {
            System.err.println(exception.getMessage());
        }

        return null;
    }

    private static synchronized void fillProcessNameList() {
        if (processNameList == null) {
            processNameList = getAllProcessNameFromDB();
        }
    }

    private static List<ProcessName> getAllProcessNameFromDB() {
        ProcessNameDAO processNameDAO = new ProcessNameDAOImp();
        return processNameDAO.getAll();
    }


}
