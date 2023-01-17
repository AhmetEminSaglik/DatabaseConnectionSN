package org.ahmeteminsaglik.utility;

import org.ahmeteminsaglik.entities.enums.EnumDataStructor;
import org.ahmeteminsaglik.entities.enums.EnumProcessName;

import java.util.Arrays;
import java.util.List;

public class EnumUtility {
    public static List<EnumProcessName> getEnumValueOfDataStructorList() {
        return Arrays.asList(EnumProcessName.values());
    }
}
