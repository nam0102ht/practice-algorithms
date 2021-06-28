package com.ntnn.arrays;

public class HideNumber {
    public static int solution(int[] nums) {
        int missNumber = nums.length;
        for (int i=0; i <nums.length;i++) {
            missNumber ^= i ^ nums[i];
        }
        return missNumber;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 0, 3}));
    }
}
