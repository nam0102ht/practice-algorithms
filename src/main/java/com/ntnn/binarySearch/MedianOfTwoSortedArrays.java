package com.ntnn.binarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 1 && nums2.length == 0) return nums1[0];
        if(nums1.length == 0 && nums2.length == 1) return nums2[0];
        int n = nums1.length;
        int m = nums2.length;
        int [] arr = new int[n + m];
        int i= 0, j = 0, k = 0;
        while(i < n && j< m) {
            if(nums1[i] < nums2[j]) arr[k++] = nums1[i++];
            else arr[k++] = nums2[j++];
        }
        while(i<n) {
            arr[k++] = nums1[i++];
        }
        while(j<m) {
            arr[k++] = nums2[j++];
        }
        int l = m + n -1;
        if((m+n)%2 != 0) {
            return arr[l / 2];
        }
        double a1 = arr[l / 2], a2 = arr[(l / 2)+1];
        return (a1 + a2)/2;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,3,5,7,8,9,11};
        int[] arr2 = new int[] {2};
        MedianOfTwoSortedArrays cal = new MedianOfTwoSortedArrays();
        System.out.println(cal.findMedianSortedArrays(arr1, arr2));
    }
}
