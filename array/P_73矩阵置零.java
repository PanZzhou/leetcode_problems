package com.pan.leetcode.array;

public class P_73矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        boolean zeroRow=false, zeroCol=false;
        for(int i=0;i<m;i++){
            if(matrix[0][i]==0){
                zeroRow=true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[i][0]==0){
                zeroCol=true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[0][j]==0||matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }
        if(zeroRow){
            for (int j = 0; j < m; j++) {
                matrix[0][j]=0;
            }
        }
        if(zeroCol)
            for (int i = 0; i < n; i++) {
                matrix[i][0]=0;
            }
    }
}
