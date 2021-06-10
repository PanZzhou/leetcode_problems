package com.pan.leetcode.dp;
//题目要求：返回第n个丑数。丑数是质因数只包含2，3，5的正整数。1也是丑数
//法一：动态规划
//法二：使用最小堆，初始堆只有1，每次取堆顶乘以2，3，5之后把三个结果放入堆内，重复取堆顶n次即为结果。
public class P_264丑数II {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int num2 = 1,num3=1,num5=1,p2,p3,p5;
        for (int i = 2; i <= n ; i++) {
            p2 = 2*dp[num2];
            p3 = 3*dp[num3];
            p5 = 5*dp[num5];
            dp[i] = Math.min(Math.min(p2,p3),p5);
            if(dp[i]==p2)
                num2++;
            if(dp[i]==p3)
                num3++;
            if(dp[i]==p5)
                num5++;
        }
        return dp[n];
    }
}
