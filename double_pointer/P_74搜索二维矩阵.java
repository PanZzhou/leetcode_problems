package com.pan.leetcode.double_pointer;

public class P_74搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        int low=0,high = m*n-1;
        while(low<=high){
            int mid = (low+high)>>1;
            int tempTarget = matrix[mid/m][mid%m]; //这里有二维数组映射到一维数组的操作。matrix[i][j]放到一维数组时，k=i*m+j;
            if(tempTarget>target)
                high=mid-1;
            else if(tempTarget<target)
                low=mid+1;
            else
                return true;
        }
        return false;
    }
}
