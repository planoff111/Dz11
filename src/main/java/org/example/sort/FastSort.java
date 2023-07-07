package org.example.sort;

public class FastSort {
    public static int partion(int[] arr, int left, int right) {
        int pivot = arr[left];

        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (arr[j] < pivot) {

                i++;

                swap(arr, i, j);
            }
        }

        swap(arr, i, left);

        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partion(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
