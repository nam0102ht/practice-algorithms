package com.ntnn.arrays;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] sumary = new int[nums.length];
        sumary[0] = 1;

        for(int i=1; i<nums.length;i++) {
            sumary[i] = sumary[i-1] * nums[i-1];
        }

        int R = 1;
        for(int i=nums.length - 1; i>= 0; i--) {
            sumary[i]= sumary[i] * R;
            R = R * nums[i];
        }
        return sumary;
    }
}
