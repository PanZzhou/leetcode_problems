package com.pan.leetcode.hot100.medium;

public class P_240搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
//        return search(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
        int m = matrix.length, n = matrix[0].length, row = 0, col = n-1;
        while(row<m && col>=0){
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
//    private boolean search(int[][] matrix, int target, int row_low, int row_high, int col_low, int col_high){
//        if(row_low > row_high || col_low > col_high)
//            return false;
//        int row_mid = (row_low+row_high)>>1;
//        int col_mid = (col_low+col_high)>>1;
//        if(matrix[row_mid][col_mid] == target)
//            return true;
//        else if(matrix[row_mid][col_mid]<target){
//            if(search(matrix, target, row_mid+1, row_high, col_low, col_mid))
//                return true;
//            if(search(matrix, target, row_low, row_mid, col_mid+1, col_high))
//                return true;
//            if(search(matrix, target, row_mid+1, row_high, col_mid+1, col_high))
//                return true;
//        }else{
//            if(search(matrix, target, row_low, row_mid-1, col_low, col_mid-1))
//                return true;
//            if(search(matrix, target, row_mid, row_high, col_low, col_mid-1))
//                return true;
//            if(search(matrix, target, row_low, row_mid-1, col_mid, col_high))
//                return true;
//        }
//        return false;
//    }
}
