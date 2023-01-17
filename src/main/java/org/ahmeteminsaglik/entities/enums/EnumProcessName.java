package org.ahmeteminsaglik.entities.enums;

public enum EnumProcessName {
    DATA_STRUCTOR_PROCESS("Data Structor Process"),
    SORT_PROCESS("Sort Process"),
    SEARCH_PROCESS("Search Process");

    private final String name;

    EnumProcessName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EnumProcessName fromString(String text) {
        for (EnumProcessName tmp : EnumProcessName.values()) {
            if (tmp.name.equalsIgnoreCase(text)) {
                return tmp;
            }
        }
        return null;
    }

}
