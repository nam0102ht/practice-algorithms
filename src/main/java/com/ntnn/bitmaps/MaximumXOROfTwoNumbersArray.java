package com.ntnn.bitmaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersArray {
    /*
    *
    *
    *
    * */

    class TrieNode {
        TrieNode left, right;
        public TrieNode() {
            left = null;
            right = null;
        }
    }

    //Insert by iteration
    public void insert(TrieNode root, int num) {
        TrieNode curr = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num>>i) & 1;
            if(bit == 0) {
                if(curr.left == null) {
                    curr.left = new TrieNode();
                }
                curr = curr.left;
            } else {
                if(curr.right == null) {
                    curr.right = new TrieNode();
                }
                curr = curr.right;
            }
        }
    }

    public int getMaxXor(TrieNode root, int num) {
        TrieNode curr = root;
        int maxXor = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = (num>>i) & 1;
            if(bit == 0) {
                if(curr.right != null) {
                    curr =  curr.right;
                    maxXor += (1<<i);
                } else {
                    curr = curr.left;
                }
            } else {
                if(curr.left != null) {
                    curr = curr.left;
                    maxXor += (1<<i);   //pow(2,i)
                } else {
                    curr = curr.right;
                }
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int maxXor = Integer.MIN_VALUE;
        for(int num: nums) {
            insert(root, num);
        }
        for(int num: nums) {
            maxXor = Math.max(maxXor, getMaxXor(root, num));
        }
        return maxXor;
    }

    public int resolveWithHashSet(int[] nums) {
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
