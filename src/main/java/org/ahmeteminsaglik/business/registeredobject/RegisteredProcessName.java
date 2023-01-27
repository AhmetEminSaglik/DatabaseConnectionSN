/*
package org.ahmeteminsaglik.business.registeredobject;

import org.ahmeteminsaglik.business.registeredobject.base.RegisteredObject;
import org.ahmeteminsaglik.core.exception.dbprocess.InvalidProcessNameRequestException;
import org.ahmeteminsaglik.core.utility.registeredobject.RegisteredObjectDBUtility;
import org.ahmeteminsaglik.entities.db.ProcessName;
import org.ahmeteminsaglik.enums.EnumProcessName;

import java.util.List;

public class RegisteredProcessName extends RegisteredObject<ProcessName> {

//    private static List<ProcessName> processNameList = null;

*/
/*    public ProcessName getByEnumProcessName(EnumProcessName enumProcessName) {
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
    }*//*



    @Override
    public ProcessName getByEnum(Enum<?> em) {

        RegisteredObjectDBUtility.fillProcessNameList(list);
        try {
            for (ProcessName processName : list) {
                System.out.println("processName.getName() : "+processName.getName());
                System.out.println("((EnumProcessName) em).getName() : "+((EnumProcessName) em).getName());
                if (processName.getName().equals(((EnumProcessName) em).getName())) {
//                    System.out.println("processName.getName() : "+processName.getName());
//                    System.out.println("((EnumProcessName) em).getName() : "+((EnumProcessName) em).getName());
                    return processName;
                }
            }
            throw new InvalidProcessNameRequestException((EnumProcessName) em);

        } catch (InvalidProcessNameRequestException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }
}
*/
