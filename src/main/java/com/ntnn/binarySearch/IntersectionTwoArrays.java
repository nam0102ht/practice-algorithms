package com.ntnn.binarySearch;

import java.util.*;

public class IntersectionTwoArrays {
    public static boolean binarySearch(int[] a, int target) {
        int low = 0, high = a.length -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] == target) return true;
            else if(a[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> lst = new HashSet<>();
        Arrays.sort(nums2);
        for(int i=0; i<nums1.length; i++) {
            if(binarySearch(nums2, nums1[i])) {
                lst.add(nums1[i]);
            }
        }
        return lst.stream().mapToInt(v -> v).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4,9,5};
        int[] arr2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}
