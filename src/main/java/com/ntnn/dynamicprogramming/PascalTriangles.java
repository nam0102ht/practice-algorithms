package com.ntnn.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangles {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> lst;
        for(int line = 1; line <= numRows; line++) {
            lst = new ArrayList<>();
            int C=1;// used to represent C(line, i)
            for(int i = 1; i <= line; i++) {
                // The first value in a line is always 1
                lst.add(C);
                C = C * (line - i) / i;
            }
            temp.add(lst);
        }
        return temp;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lst = new ArrayList<>();
        long C=1;// used to represent C(line, i)
        for(int i = 1; i <= rowIndex + 1; i++) {
            // The first value in a line is always 1
            lst.add(Integer.parseInt(C + ""));
            C = C * (rowIndex + 1 - i) / i;
        }
        return lst;
    }

}
