package com.pan.leetcode.string;

public class kmp {
    public int strKmp(String s, String p){
        int[] next = getNext(p);
        int i = 0, j = 0;
        while(i<s.length() && j<p.length()){
            if(j == -1 || s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else
                j = next[j];
        }
        if(j<p.length())
            return -1;
        return i-j;
    }

    private int[] getNext(String p){
        int[] ret = new int[p.length()];
        ret[0] = -1;
        int i = 0, k = -1;
        while(i<p.length()-1){
            if(k==-1 || p.charAt(k) == p.charAt(i)){
//                ret[++i] = ++k;
                if(p.charAt(++k) == p.charAt(++i))//当两个字符相等时要跳过
                    ret[i] = ret[k];
                else
                    ret[i] = k;
            }else
                k = ret[k];
        }
        return ret;
    }
}
