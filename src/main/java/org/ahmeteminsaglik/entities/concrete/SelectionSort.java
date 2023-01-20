package org.ahmeteminsaglik.entities.concrete;

import org.ahmeteminsaglik.entities.abstracts.SortAlgorithmBase;

import java.util.List;

public class SelectionSort implements SortAlgorithmBase {
    @Override
    public void sort(List<String> list) {
        selectionSort(list);
    }

    @Override
    public void sort(String[] arr) {
        selectionSort(arr);
    }

    private void selectionSort(List<String> list) {
        // Find the string reference that should go in each cell of
        // the array, from cell 0 to the end
        for (int j = 0; j < list.size() - 1; j++) {
            // Find min: the index of the string reference that should go into cell j.
            // Look through the unsorted strings (those at j or higher) for the one that is first in lexicographic order
            int min = j;
            for (int k = j + 1; k < list.size(); k++)
                if (list.get(k).compareTo(list.get(min)) < 0) min = k;

            // Swap the reference at j with the reference at min
            String temp = list.get(j);
            list.set(j, list.get(min));
            list.set(min, temp);
        }

    }

    public static void selectionSort(String[] array) {

        // Find the string reference that should go in each cell of
        // the array, from cell 0 to the end
        for (int j = 0; j < array.length - 1; j++) {
            // Find min: the index of the string reference that should go into cell j.
            // Look through the unsorted strings (those at j or higher) for the one that is first in lexicographic order
            int min = j;
            for (int k = j + 1; k < array.length; k++)
                if (array[k].compareTo(array[min]) < 0) min = k;

            // Swap the reference at j with the reference at min
            String temp = array[j];
            array[j] = array[min];
            array[min] = temp;
        }

    }


}
