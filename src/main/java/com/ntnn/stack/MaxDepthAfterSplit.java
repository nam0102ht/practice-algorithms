package com.ntnn.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxDepthAfterSplit {
    public static int[] maxDepth(String s) {
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        int[] ans = new int[s.length()];
        Arrays.fill(ans, 0);
        char[] chars = s.toCharArray();
        int i = 0;
        for(char c : chars) {
            if(c == '(') {
                if(stackA.size() >= stackB.size()) {
                    stackB.push(c);
                }
                else {
                    stackA.push(c);
                    ans[i] = 1;
                }
            }
            else {
                if(stackA.size() >= stackB.size()) {
                    stackA.pop();
                    ans[i] = 1;
                } else {
                    stackB.pop();
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxDepth("(()())")));
    }
}
