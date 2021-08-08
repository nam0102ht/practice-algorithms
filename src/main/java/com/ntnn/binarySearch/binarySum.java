package com.ntnn.binarySearch;

public class binarySum {
    public static int binarySum(int[ ] data, int low, int high) {
        if (low > high) // zero elements in subarray
            return 0;
        else if (low == high) // one element in subarray
            return data[low];
        else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,7,11,15,16,18,21,28};
        System.out.println(binarySum(arr, 0, arr.length-1));
    }
}
