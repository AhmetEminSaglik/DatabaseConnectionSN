package org.ahmeteminsaglik.entities.enums;

public enum EnumSortAlgorithm {
    SEARCH_NODE("SearchNode"), QUICK_SORT("Quick Sort"), INTRO_SORT("Intro Sort"), TIM_SORT("Tim Sort"), MERGE_SORT("Merge Sort"), HEAP_SORT("Heap Sort"),
    INSERTION_SORT("Insertion Sort"), BUBBLE_SORT("Bubble Sort"), SELECTION_SORT("Selection Sort");
    private final String name;

    EnumSortAlgorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
