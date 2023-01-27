package org.ahmeteminsaglik.core.utility.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.base.RegisteredObject;
import org.ahmeteminsaglik.entities.db.ProcessName;

import java.util.List;

public class RegisteredObjectDBUtility {
    private static List<ProcessName> processNameList = null;

    /*public static ProcessName getRequestedProcessNameByGivenEnumProcessName(EnumProcessName enumProcessName) {
        fillProcessNameList();
        try {
            for (ProcessName processName : processNameList) {
                if (processName.getName().equals(enumProcessName.getName())) {
                    return processName;
                }
            }
            throw new InvalidRequestDataException(enumProcessName);

        } catch (InvalidRequestDataException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }
*/
    public static synchronized <T> void fillList(RegisteredObject<T> registeredObject) {
        if (registeredObject.getList() == null) {
            registeredObject.setList(registeredObject.getDao().getAll());
        }
    }

//    private static <T> List<T> getAllProcessNameFromDB(BaseDAO<T> baseDAO) {
//        ProcessNameDAO processNameDAO = new ProcessNameDAOImp();
//        return baseDAO.getAll();
//    }


}
