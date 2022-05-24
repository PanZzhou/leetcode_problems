package com.pan.leetcode.everyday;

public class P_60排列序列 {
    public String getPermutation(int n, int k) {
        boolean[] vis = new boolean[n+1];
        int mul = 1, epoch = n-1;
        StringBuilder ret = new StringBuilder();
        //(n-1)!
        for (int i = 1; i < n; i++) {
            mul *= i;
        }
        while(epoch > 0){
            int order = (k-1)/mul + 1;
            ret.append(getInx(vis, order));
            k = (k-1)%mul + 1;
            mul /= epoch;
            epoch--;
        }
        for (int i = 1; i <= n; i++) {
            if(!vis[i]){
                ret.append(i);
            }
        }
        return ret.toString();
    }
    private int getInx(boolean[] vis, int order){
        int ret = 0, num = 0;
        for (int i = 1; i < vis.length; i++) {
            if(!vis[i]){
                num++;
                if(num == order){
                    vis[i] = true;
                    ret = i;
                    break;
                }
            }
        }
        return ret;
    }
}
