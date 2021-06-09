package com.pan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class P_54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return res;
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        while(left<=right&&top<=bottom){
            for(int col = left;col<=right;++col)
                res.add(matrix[top][col]);
            for(int row = top+1;row<=bottom;row++)
                res.add(matrix[row][right]);
            if(left<right&&top<bottom){
                for(int col=right-1;col>left;col--)
                    res.add(matrix[bottom][col]);
                for(int row=bottom;row>top;row--)
                    res.add(matrix[row][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
