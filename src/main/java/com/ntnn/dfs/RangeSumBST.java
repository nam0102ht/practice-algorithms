package com.ntnn.dfs;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    private int dfs(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        if(root.val < low) {
            return dfs(root.right, low, high);
        } else if (root.val > high) {
            return dfs(root.left, low, high);
        } else {
            return dfs(root.right, low, high) + dfs(root.left, low, high) + root.val;
        }
    }
}
