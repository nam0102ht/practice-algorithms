package com.ntnn.dfs;

public class IncreasingOrderSearchTree {
    TreeNode cur = new TreeNode(0);
    TreeNode res = cur;

    public void inorder(TreeNode node){
        if(node == null)return;
        inorder(node.left);
        cur.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        cur.left = cur.right = null;
        return res.right;
    }
}
