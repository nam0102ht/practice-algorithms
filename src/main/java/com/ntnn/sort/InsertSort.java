package com.ntnn.sort;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int []data) {
        int k, j, cur;
        for(k = 1; k < data.length; k++) {
            cur = data[k];
            j = k;
            while(j>0 && data[j - 1] > cur) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = cur;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 6, 2, 3, 1, 8, 9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
