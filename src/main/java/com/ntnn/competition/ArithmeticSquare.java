package com.ntnn.competition;
import java.util.*;
public class ArithmeticSquare {
    public static int result(int [][] arr) {
        int k = (arr[1][0] + arr[1][2]) / 2;
        arr[1][1] = k;
        List<Integer> sumList = new ArrayList<>();
        int middleRow = arr[1][0] + arr[1][1] + arr[1][2];
        int middle = arr[0][1] + arr[1][1] + arr[2][1];
        int top= arr[0][0] + arr[0][1] + arr[0][2];
        int left = arr[0][0] + arr[1][0] + arr[2][0];
        int bottom = arr[2][0] +arr[2][1] +arr[2][2];
        int right = arr[0][2] + arr[1][2]+ arr[2][2];
        int topRight = arr[0][0] + arr[1][1] + arr[2][2];
        int topLeft = arr[0][2] + arr[1][1] + arr[2][0];
        sumList.add(middle);
        sumList.add(middleRow);
        sumList.add(top);
        sumList.add(left);
        sumList.add(bottom);
        sumList.add(right);
        sumList.add(topRight);
        sumList.add(topLeft);
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : sumList) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        int max = Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
        return max < 8 ? max + 1 : max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int [][]arr = new int[3][3];
            for(int j=0; j<3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(k == 1 && j == 1) {
                        arr[j][k] = Integer.MIN_VALUE;
                    } else arr[j][k] = scanner.nextInt();
                }
            }
            result.add(result(arr));
        }
        for(int i=0; i<result.size(); i++) {
            System.out.println("Case #"+i+": "+result.get(i));
        }
    }
}
