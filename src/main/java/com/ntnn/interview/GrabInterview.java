package com.ntnn.interview;

import java.util.*;

public class GrabInterview {
    // question 1
    public int steps(int[] A, int target) {
        return 0;
    }

    // question 2
    public boolean balance(String S) {
        Map<Character, Integer> maps = new HashMap<>();
        char[] chars = S.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(!maps.containsKey(chars[i])) {
                maps.put(chars[i], 1);
            } else {
                maps.put(chars[i], maps.get(chars[i]) + 1);
            }
        }
        for(int i=0; i< chars.length; i++) {
            if(Character.isLowerCase(chars[i])) {
                if(!maps.containsKey(Character.toUpperCase(chars[i]))) {
                    return false;
                }
            }
            else {
                if(!maps.containsKey(Character.toLowerCase(chars[i]))) {
                    return false;
                }
            }
        }
        return true;
    }
    public int solution(String S) {
        // write your code in Java SE 8
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<S.length(); i++) {
            for (int j =i+1; j<S.length();j++) {
                if(balance(S.substring(i, j+1))) {
                    answer = Math.min(answer, j - i + 1);
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // question 3
    public void dfs(int i, Map<Integer, List<Integer>> lst, boolean[] visited) {
        visited[i] = true;
        if (!lst.containsKey(i+1)) return;
        List<Integer> v = lst.get(i+1);
        v.forEach(k -> {
            if(!visited[k-1]) {
                dfs(k-1, lst, visited);
            }
        });
    }

    public boolean isConnected(int n, Map<Integer, List<Integer>> lst) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
                dfs(i, lst, visited);
            }
        }
        return true;
    }

    public boolean solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int n = A.length;
        Map<Integer, List<Integer>> maps = new HashMap<>();
        for (int i =0; i<n; i++) {
            if(!maps.containsKey(A[i])) {
                maps.put(A[i], new ArrayList<>());
            }
            List<Integer> lstTemp = maps.get(A[i]);
            lstTemp.add(B[i]);
        }

        if (!isConnected(n, maps)) {
            return false;
        }

        Set<Integer> keys = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(maps.get(i+1).size() != 1) {
                return false;
            }
        }
        for(int i=0; i<n; i++) {
            int k = maps.get(i+1).get(0);
            if(keys.contains(k) || i+1 == k) {
                return false;
            }
            keys.add(k);
        }
        return true;

    }
}
