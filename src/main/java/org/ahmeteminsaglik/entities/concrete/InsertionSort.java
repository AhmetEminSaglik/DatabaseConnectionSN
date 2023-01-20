package org.ahmeteminsaglik.entities.concrete;

import org.ahmeteminsaglik.entities.abstracts.SortAlgorithmBase;

import java.util.List;

public class InsertionSort implements SortAlgorithmBase {
    @Override
    public void sort(List<String> list) {
        sortWithInsertionSort(list);
    }

    @Override
    public void sort(String[] arr) {
        sortWithInsertionSort(arr);
    }

    private void sortWithInsertionSort(String[] array) {
        String temp = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private void sortWithInsertionSort(List<String> list) {
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}
