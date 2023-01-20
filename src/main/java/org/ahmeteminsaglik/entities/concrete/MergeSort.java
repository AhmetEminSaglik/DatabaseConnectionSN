package org.ahmeteminsaglik.entities.concrete;

import org.ahmeteminsaglik.entities.abstracts.SortAlgorithmBase;

import java.util.Arrays;
import java.util.List;

public class MergeSort implements SortAlgorithmBase {
    @Override
    public void sort(List<String> list) {
        list = sortWithMergeSort(list);
    }

    @Override
    public void sort(String[] arr) {
        arr = sortWithMergeSort(arr);

    }


    public static String[] sortWithMergeSort(String[] list) {
        String[] sorted = new String[list.length];
        if (list.length == 1) {
            sorted = list;
        } else {
            int mid = list.length / 2;
            String[] left = null;
            String[] right = null;
            if ((list.length % 2) == 0) {
                left = new String[list.length / 2];
                right = new String[list.length / 2];
            } else {
                left = new String[list.length / 2];
                right = new String[(list.length / 2) + 1];
            }
            int x = 0;
            int y = 0;
            for (; x < mid; x++) {
                left[x] = list[x];
            }
            for (; x < list.length; x++) {
                right[y++] = list[x];
            }
            left = sortWithMergeSort(left);
            right = sortWithMergeSort(right);
            sorted = mergeArray(left, right);
        }

        return sorted;
    }

    private static String[] mergeArray(String[] left, String[] right) {
        String[] merged = new String[left.length + right.length];
        int lIndex = 0;
        int rIndex = 0;
        int mIndex = 0;
        int comp = 0;
        while (lIndex < left.length || rIndex < right.length) {
            if (lIndex == left.length) {
                merged[mIndex++] = right[rIndex++];
            } else if (rIndex == right.length) {
                merged[mIndex++] = left[lIndex++];
            } else {
                comp = left[lIndex].compareTo(right[rIndex]);
                if (comp > 0) {
                    merged[mIndex++] = right[rIndex++];
                } else if (comp < 0) {
                    merged[mIndex++] = left[lIndex++];
                } else {
                    merged[mIndex++] = left[lIndex++];
                }
            }
        }
        return merged;
    }


    public static List<String> sortWithMergeSort(List<String> list) {
        List<String> sortedList;
        if (list.size() == 1) {
            sortedList = list;
        } else {
            int mid = list.size() / 2;
            List<String> leftList = null;
            List<String> rightList = null;
            if ((list.size() % 2) == 0) {
                leftList = Arrays.asList(new String[list.size() / 2]);
                rightList = Arrays.asList(new String[list.size() / 2]);
            } else {
                leftList = Arrays.asList(new String[list.size() / 2]);
                rightList = Arrays.asList(new String[(list.size() / 2) + 1]);
            }
            int x = 0;
            int y = 0;
            for (; x < mid; x++) {
                leftList.set(x, list.get(x));
            }
            for (; x < list.size(); x++) {
                rightList.set(y++, list.get(x));
            }
            leftList = sortWithMergeSort(leftList);
            rightList = sortWithMergeSort(rightList);
            sortedList = mergeArray(leftList, rightList);
        }

        return sortedList;
    }

    private static List<String> mergeArray(List<String> leftList, List<String> rightList) {
        List<String> mergedList = Arrays.asList(new String[leftList.size() + rightList.size()]);
        int lIndex = 0;
        int rIndex = 0;
        int mIndex = 0;
        int comp = 0;
        while (lIndex < leftList.size() || rIndex < rightList.size()) {
            if (lIndex == leftList.size()) {
                mergedList.set(mIndex++, rightList.get(rIndex++));
            } else if (rIndex == rightList.size()) {
                mergedList.set(mIndex++, leftList.get(lIndex++));
            } else {
                comp = leftList.get(lIndex).compareTo(rightList.get(rIndex));
                if (comp > 0) {
                    mergedList.set(mIndex++, rightList.get(rIndex++));
                } else if (comp < 0) {
                    mergedList.set(mIndex++, leftList.get(lIndex++));
                } else {
                    mergedList.set(mIndex++, leftList.get(lIndex++));
                }
            }
        }
        return mergedList;
    }
}

