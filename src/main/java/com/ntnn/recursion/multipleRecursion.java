package com.ntnn.recursion;

import java.util.ArrayList;
import java.util.List;

public class multipleRecursion {
    public static List<Character> PuzzleSolve(int k, List<Character> s, List<Character> u) {
        char v, h;
        for(char c : u) {
            u.remove(c);
            s.add(c);
            if(k == 1) {
                return s;
            }
            else PuzzleSolve(k - 1, s, u);
            u.add(c);
            s.remove(c);
        }
        return new ArrayList<>();
    }

}
