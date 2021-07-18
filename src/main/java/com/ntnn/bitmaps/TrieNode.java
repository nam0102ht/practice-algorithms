package com.ntnn.bitmaps;

public class TrieNode {
    /*
     * Initialized TrieNode with left and right
     * Create func insert to TrieNode with numbers and it's save from 31 -> 0 elements
     * If bit = (num>>i) & 1 == 0, it will be saved in left node.
     * else bit = (num>>i) & 1 == 1, it will be saved in right node
     * Get MaxXOR will check num is left or right by bit=(num>>i) & 1 then get MaxXOR by maxXOR += 1<<i
     * */

    TrieNode left, right;
    public TrieNode() {
        left = null;
        right = null;
    }
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
}
