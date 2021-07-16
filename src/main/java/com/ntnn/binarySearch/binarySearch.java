package com.ntnn.binarySearch;

import java.util.Arrays;

public class binarySearch {
    /*
    * The arrays were sorted
    * Calculating mid by calculation formula mid = low + high
    * Found by low if arr[mid] < target
    * Found by high if arr[mid] > target
    * */

    public static boolean binarySearch(int [] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    public static boolean search(int [] arr, int target, int low, int high) {
        if(low > high) return false;
        else {
            int mid = low + ((high - low) / 2);
            if (target == arr[mid]) return true;
            else if (target < arr[mid]) return search(arr, target, low, mid - 1);
            return search(arr, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 5, 6, 7, 8, 199, 193, 11, 23, 22};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 199));
    }
}
