package org.ahmeteminsaglik.entities.enums;

public enum EnumProcessName {
    DATA_STRUCTOR("Data Structor"),
    SORT_PROCESS("Sort Process"),
    SEARCH_PROCESS("Search Process");
    private final String name;

    EnumProcessName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
