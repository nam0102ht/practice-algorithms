package com.ntnn.binarySearch;

public class sqrt {

    public static int mySqrt(int x) {
        long low = 1;
        long high = x;
        long mid;

        while (low <= high){
            mid = (high+low)/2;

            if (mid * mid == x){
                return (int) mid;
            }
            if (mid*mid > x){
                high = mid-1;
            }
            else if (mid*mid < x){
                low = mid + 1;
            }
        }

        mid = (high+low)/2;
        return (int) mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
