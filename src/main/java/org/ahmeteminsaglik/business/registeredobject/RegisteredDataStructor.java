/*
package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.core.exception.dbprocess.InvalidProcessNameRequestException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.entities.db.DataStructor;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.enums.EnumProcessName;

import java.util.List;

public class RegisteredDataStructor {
    private static List<DataStructor> dataStructorList = null;

    public ProcessName getByEnumProcessName(EnumProcessName enumProcessName) {
        RegisteredObjectDBUtility.fillProcessNameList();
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
}
*/
