package com.pan.leetcode.剑指offer.easy;

public class P_剑指Offer29顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        int lrow = 0, hrow = matrix.length-1, lcol = 0, hcol = matrix[0].length-1;
        int[] ret = new int[matrix.length * matrix[0].length];
        int inx = 0;
        while(lrow <= hrow && lcol <= hcol){
            for (int i = lcol; i <= hcol; i++) {
                ret[inx++] = matrix[lrow][i];
            }
            for (int i = lrow+1; i <= hrow; i++) {
                ret[inx++] = matrix[i][hcol];
            }
            if(lrow < hrow){
                for (int i = hcol-1; i >= lcol; i--) {
                    ret[inx++] = matrix[hrow][i];
                }
            }
            if(lcol < hcol){
                for (int i = hrow-1; i > lrow; i--) {
                    ret[inx++] = matrix[i][lcol];
                }
            }
            lrow++;
            hrow--;
            lcol++;
            hcol--;
        }
        return ret;
    }
}
