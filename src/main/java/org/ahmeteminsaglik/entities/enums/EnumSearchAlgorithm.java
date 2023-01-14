package org.ahmeteminsaglik.entities.enums;

public enum EnumSearchAlgorithm {
    SEARCH_NODE("SearchNode"), LINEAR_SEARCH("Linear Search"), BINARY_SEARCH("Binary Search"), TERNARY_SEARCH("Ternary Search"), JUMP_SEARCH("Jump Search"),
    INTERPOLATION_SEARCH("Interpolation Search"), EXPONENTIAL_SEARCH("Exponential Search"), FIBONACCI_SEARCH("Fibonacci Search"),
    BREADTH_FIRST_SEARCH("Breadth First Search"),DEPTH_FIRST_SEARCH("Depth First Search");
    private final String name;

    EnumSearchAlgorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
