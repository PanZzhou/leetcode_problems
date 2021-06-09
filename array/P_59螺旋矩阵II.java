package com.pan.leetcode.array;

public class P_59螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left=0,right=n-1,top=0,bottom=n-1,index=1;
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++)
                res[top][i]=index++;
            for(int i=top+1;i<=bottom;i++)
                res[i][right]=index++;
            if(left<=right||top<=bottom){
                for(int i=right-1;i>=left;i--)
                    res[bottom][i] = index++;
                for(int i=bottom-1;i>top;i--)
                    res[i][left]=index++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
