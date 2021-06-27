package com.ntnn.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NAryTreePreorderTraversal {
    List<Integer> lst = new ArrayList<>();
    Deque<Integer> lstArr = new ArrayDeque<>();
    //recursive

    public void preOrderNArray(Node node) {
        if(node == null) return;
        lst.add(node.val);
        for(Node subNode : node.children) {
            preOrderNArray(subNode);
        }
    }

    public List<Integer> preorder(Node root) {
        preOrderNArray(root);
        return lst;
    }

    public List<Integer> postorderOrder(Node root) {
        preOrderNArrayHelper(root);
        return lstArr.stream().collect(Collectors.toList());
    }
    public void preOrderNArrayHelper(Node node) {
        if(node == null) return;
        lstArr.add(node.val);
        for(Node subNode : node.children) {
            preOrderNArray(subNode);
        }
    }
}
