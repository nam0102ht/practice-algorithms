package com.ntnn.binarySearch;

public class CountNegativeNumbersSortedMatrix {

    public int search(int [] arr) {
        int l =0, h = arr.length-1;
        // binary search
        while(l <= h){
            int m = l+(h-l)/2;
            if(arr[m]>=0) l = m+1;
            else h = m-1;
        }
        return arr.length-l;
    }

    public int countNegatives(int[][] grid) {
        int sum = 0;
        for(int i=0; i < grid.length; i++) {
            int low = 0;
            sum += search(grid[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        CountNegativeNumbersSortedMatrix countNegativeNumbersSortedMatrix = new CountNegativeNumbersSortedMatrix();
        int[][] arr = new int[][] {{1,-1},{-1,-1}};
        System.out.println(countNegativeNumbersSortedMatrix.countNegatives(arr));
    }
}
