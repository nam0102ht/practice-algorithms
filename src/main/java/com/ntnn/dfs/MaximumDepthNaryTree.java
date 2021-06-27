package com.ntnn.dfs;

import java.util.Map;

public class MaximumDepthNaryTree {
    int max = 0;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return helper(root, 1);
    }
    public int helper(Node node, int index) {
        if(node.children.isEmpty()) return index;
        for(Node subNode : node.children) {
            int curr = helper(subNode, index + 1);
            max = Math.max(curr, max);
        }
        return max;
    }
}
