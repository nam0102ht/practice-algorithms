package com.ntnn.dfs;

public class JumGame3 {
    public boolean canReach(int[] arr, int start) {
        if(start >= 0 && start < arr.length && arr[start] >= 0) {
            if(arr[start] == 0) return true;
            arr[start] *= -1;
            return canReach(arr, start + arr[start])
                    || canReach(arr, start - arr[start]);
        }
        return false;
    }
}
