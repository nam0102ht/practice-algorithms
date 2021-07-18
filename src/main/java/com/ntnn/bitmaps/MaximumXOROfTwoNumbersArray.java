package com.ntnn.bitmaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersArray {
    /*
    * Initialized TrieNode by inserting value of array to TrieNode
    * Then getMax or by check maxXor with getMaxXor func
    * */

    //Insert by iteration
    private int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int maxXor = Integer.MIN_VALUE;
        for(int num: nums) {
            root.insert(root, num);
        }
        for(int num: nums) {
            maxXor = Math.max(maxXor, root.getMaxXor(root, num));
        }
        return maxXor;
    }

    private int resolveWithHashSet(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = ~((1 << i) - 1);
            int tmp = max | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num: nums){
                int val = num & mask;
                if(set.contains(tmp ^ val))
                    max = Math.max(max, tmp);
                set.add(val);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {3,10,5,25,2,8};
        MaximumXOROfTwoNumbersArray maxiXOR = new MaximumXOROfTwoNumbersArray();
        System.out.println(maxiXOR.findMaximumXOR(arr));
        System.out.println(maxiXOR.resolveWithHashSet(arr));
    }
}
