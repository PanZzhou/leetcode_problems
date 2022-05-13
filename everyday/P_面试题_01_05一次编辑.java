package com.pan.leetcode.everyday;

public class P_面试题_01_05一次编辑 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if(Math.abs(m -n) > 1) return false;
        int i = 0, j = 0;
        boolean isFix = false;
        while(i<m && j < n){
            char a = first.charAt(i);
            char b = second.charAt(j);
            if(a!=b){
                if(isFix) return false;
                if(m == n){
                    i++;j++;
                }
                else if(m > n) i++;
                else j++;
                isFix = true;
            }else{
                i++;j++;
            }
        }
        return true;
    }
}
