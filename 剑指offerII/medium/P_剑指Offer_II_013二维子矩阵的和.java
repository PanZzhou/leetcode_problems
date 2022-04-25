package com.pan.leetcode.剑指offerII.medium;

import java.lang.management.MemoryManagerMXBean;

public class P_剑指Offer_II_013二维子矩阵的和 {
    private int[][] mMatrix;
    private int m;
    private int n;
    public P_剑指Offer_II_013二维子矩阵的和(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        mMatrix = matrix;
        for (int i = 1; i < m; i++) {
            mMatrix[i][0] += mMatrix[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            mMatrix[0][i] += mMatrix[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mMatrix[i][j] += mMatrix[i-1][j] + mMatrix[i][j-1] - mMatrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = 0, up = 0, left_up = 0;
        if(col1!=0)
            left = mMatrix[row2][col1-1];
        if(row1!=0)
            up = mMatrix[row1-1][col2];
        if(col1 !=0 && row1 != 0)
            left_up = mMatrix[row1-1][col1-1];
        return mMatrix[row2][col2] - left - up + left_up;
    }
}
