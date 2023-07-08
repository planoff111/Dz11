package org.example.sort;

public class BinarySearch {

    public static int search(int[] sortedArray, int key) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                return mid;
            }
        }
        return -1;
    }
}
