package com.pan.leetcode.dp.二维类;

import java.util.Arrays;

public class P_542_01矩阵 {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null)
            return mat;
        int n=mat.length, m=mat[0].length;
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ret[i], Integer.MAX_VALUE-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j]==0)
                    ret[i][j] = 0;
                else{
                    if(j>0)
                        ret[i][j] = Math.min(ret[i][j], ret[i][j-1] + 1);
                    if(i>0)
                        ret[i][j] = Math.min(ret[i][j], ret[i-1][j] + 1);
                }
            }
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                if(mat[i][j]!=0){
                    if(j<m-1)
                        ret[i][j] = Math.min(ret[i][j], ret[i][j+1] + 1);
                    if(i<n-1)
                        ret[i][j] = Math.min(ret[i][j], ret[i+1][j] + 1);
                }
            }
        }
        return ret;
    }
}
