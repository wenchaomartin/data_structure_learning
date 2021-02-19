package me.data.structure.learning.sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int a[], int start, int end) {
        if (start >= end) return;
        int pivot = partition(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    public static int partition(int a[], int start, int end) {
        int count = start;
        int pivot = end;
        for (int j = start; j <= end - 1; j++) {
            if (a[j] < a[pivot]) {
                int temp = a[j];
                a[j] = a[count];
                a[count] = temp;
                count++;
            }
        }
        int temp = a[end];
        a[end] = a[count];
        a[count] = temp;
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 7, 6, 3, 5};
        QuickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
