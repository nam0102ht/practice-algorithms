package com.ntnn.dynamicprogramming;

import java.util.Arrays;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        if(n == 1) {
            return arr[n];
        }
        arr[2] = 2;
        if(n == 2) {
            return arr[n];
        }
        for(int i=3; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
