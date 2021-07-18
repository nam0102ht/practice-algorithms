package com.ntnn.bitmaps;

import java.util.Arrays;

public class MaximumXORWithElementFromArray {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        TrieNode root = new TrieNode();
        int[] result = new int[queries.length];
        int[][] query = new int[queries.length][3];

        for(int i = 0; i < queries.length; i++) {
            query[i][0] = queries[i][0];
            query[i][1] = queries[i][1];
            query[i][2] = i;
        }

        Arrays.sort(nums);
        Arrays.sort(query, (a,b)->(a[1]-b[1]));
        int index = 0;
        for(int i = 0; i < query.length; i++) {
            while(index < nums.length && nums[index] <= query[i][1]) {
                root.insert(root, nums[index]);
                index++;
            }

            if(nums[0] > query[i][1]) {
                result[query[i][2]] = -1;
            } else {
                result[query[i][2]] = root.getMaxXor(root, query[i][0]);
            }
        }
        return result;
    }
}
