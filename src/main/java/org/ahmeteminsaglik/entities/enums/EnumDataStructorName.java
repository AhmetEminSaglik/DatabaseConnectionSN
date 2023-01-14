package org.ahmeteminsaglik.entities.enums;

public enum EnumDataStructorName {
    ARRAY("Array"), ARRAYLIST("ArrayList"), SEARCHNODE_V1("SearchNode V1"), SEARCHNODE_V2("SearchNode V2");
    private final String name;

    EnumDataStructorName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
