package com.ntnn.dfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<>();
        helper(root, "", lst);
        return lst;
    }
    public void helper(TreeNode node, String str, List<String> lst) {
        if(node == null) {
            return;
        } else {
            if(node.left == null && node.right == null) {
                str += node.val;
                lst.add(str);
                return;
            }
            str += node.val + "->";
            helper(node.left, str, lst);
            helper(node.right, str, lst);
        }
    }
}
