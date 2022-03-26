package com.pan.leetcode.剑指offer;

public class P_剑指Offer13机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        if(k==0) return 1;
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        int ret = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(transform(i)+transform(j) > k)
                    continue;
                if(i-1>0)
                    vis[i][j] |= vis[i-1][j];
                if(j-1>0)
                    vis[i][j] |= vis[i][j-1];
                ret += vis[i][j]?1:0;
            }
        }
        return ret;
    }
    private int transform(int num){
        int sum = 0;
        while(num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
