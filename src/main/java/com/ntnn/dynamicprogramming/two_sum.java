package com.ntnn.dynamicprogramming;

public class two_sum {
    /*
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    O(n^2)
    */
    public int[] twoSum(int[] nums, int target) {
        int sum = 0;
        int[] result = new int[2];
        for(int i = 0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
