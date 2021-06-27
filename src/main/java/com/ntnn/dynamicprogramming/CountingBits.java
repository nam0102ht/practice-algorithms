package com.ntnn.dynamicprogramming;

public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num  + 1];
        for (int i = 0; i <= num; i++) {
            if (i <= 1) {
                res[i] = i&1;
            } else {
                res[i] = res[i>>1] + (i&1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("" + (8>>1));
        System.out.println("" + (8&1));
    }
}
