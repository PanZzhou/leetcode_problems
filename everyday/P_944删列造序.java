package com.pan.leetcode.everyday;

public class P_944删列造序 {
    public int minDeletionSize(String[] strs) {
        if(strs.length == 0) return 0;
        int ret = 0, n = strs[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    ret ++;
                    break;
                }
            }
        }
        return ret;
    }
}
