package com.pan.leetcode.dp;
/*
动态规划：
    1.无后效性：f(i, j)f(i,j) 和任何的 f(i', j')无关。(其中i' > i, j' > j)
    2.最优子结构：即当前问题的最优解取决于子问题的最优解
动态规划的题目分为两大类：
    一种是求最优解类，典型问题是背包问题（最优子结构），
    另一种就是计数类，比如这里的统计方案数的问题，它们都存在一定的递推性质。（当前问题的方案数取决于子问题的方案数）
动态规划空间优化：滚动数组思想
    当我们定义的状态在动态规划的转移方程中只和某几个状态相关的时候，就可以考虑这种优化方法
    比如这里f(i,j) 只与f(i−1,j) 和f(i,j−1) 相关，并且循环是按照行来的。
 */
public class P_63不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length,m=obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0]=obstacleGrid[0][0]==0?1:0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[j] = 0;
                    continue;
                }
                if(j-1>=0&&obstacleGrid[i][j]!=1)
                    dp[j] += dp[j-1];
            }
        }
        return dp[m-1];
    }
}
