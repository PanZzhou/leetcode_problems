package com.pan.leetcode.everyday;

public class P_面试题_17_11单词距离 {
    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length;
        int l=-1,r=-1;
        boolean vis;
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            String cur = words[i];
            vis = false;
            if(cur.equals(word1)){
                l=i;
                vis = true;
            }
            if(!vis && cur.equals(word2))
                r=i;
            if(l!=-1 && r!=-1)
                ret = Math.min(ret, Math.abs(r-l));
        }
        return ret;
    }
}
