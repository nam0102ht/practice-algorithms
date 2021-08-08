package com.ntnn.stack;

import java.util.Stack;

public class MaxDeep {
    public static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int max = 0;
        for(char c : chars) {
            if(c == '(') {
                stack.push(c);
                max = Math.max(max, stack.size());
            }
            if(c == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1)"));
    }
}
