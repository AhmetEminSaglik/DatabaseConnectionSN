package org.ahmeteminsaglik.entities.concrete;

import org.ahmeteminsaglik.entities.abstracts.SortAlgorithmBase;

import java.util.List;

public class BubbleSort implements SortAlgorithmBase {
    @Override
    public void sort(List<String> list) {
        sortWithBubbleSort(list);
    }

    @Override
    public void sort(String[] arr) {
        sortWithBubbleSort(arr);
    }


    public static void sortWithBubbleSort(String[] arr) {
        String temp;
        for (int j = 0; j < arr.length; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                // comparing adjacent strings
                if (arr[i].compareTo(arr[j]) < 0) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void sortWithBubbleSort(List<String> list) {
        String temp;
        for (int j = 0; j < list.size(); j++) {
            for (int i = j + 1; i < list.size(); i++) {
                // comparing adjacent strings
                if (list.get(i).compareTo(list.get(j)) < 0) {
                    temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }

}
