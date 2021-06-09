package com.pan.leetcode.number;

public class P_62不同路径 {
    public int uniquePaths(int m, int n) {
        if(m<n){
            int temp = m;
            m=n;
            n=temp;
        }
        return Cmn(m+n-1,n-1);
    }
    private int Cmn(int m, int n){
        if(n==0||m==n)
            return 1;
        if(n>m/2)
            n=m-n;
        int num=1;
        long ans=1;
        while(num<=n){
            ans = ans*m/num;
            num++;
            m--;
        }
        return (int)ans;
    }
}
