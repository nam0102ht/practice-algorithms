package com.ntnn.binarySearch;

import java.util.Arrays;

public class SumSortedArray2 {
    private static int binarySearch(int[] arr, int target, int low) {
        int high = arr.length -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static int[] twoSum(int[] arr, int target) {
        int a = 0, b = 0;
        for(int i = 0; i<arr.length;i++) {
            a = i + 1;
            b = binarySearch(arr, (target - arr[i]), i + 1);
            if(b>-1&&i!=b){
                a=i+1;
                b=b+1;
                break;
            }
        }
        return new int[] {a, b};
    }

    public static int[] twoArr(int[] arr, int target) {
        int i =0, j=arr.length-1;
        while(i < j) {
            if(arr[i] + arr[j] == target) {
                return new int[] {i + 1, j + 1};
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] {i + 1, j + 1};
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,7,11,15};
        Arrays.stream(twoArr(arr, 9)).forEach(v -> {
            System.out.println(v);
        });
    }
}
