package com.pan.leetcode.hot100.hard;

import javax.print.DocFlavor;
import java.util.ArrayDeque;
import java.util.Deque;

public class P_85最大矩形 {
    //单调栈
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if(m == 0) return 0;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '1')
                    left[i][j] = (j==0?0:left[i][j-1]) + 1;
            }
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] up = new int[m];
            Deque<Integer> mono_stack = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                while(!mono_stack.isEmpty() && left[mono_stack.peek()][i] >= left[j][i]){
                    int pre = mono_stack.pop();
                    ret = Math.max(ret, left[pre][i] * (j-up[pre]-1));
                }
                up[j] = mono_stack.isEmpty()?-1:mono_stack.peek();
                mono_stack.push(j);
            }
            if(!mono_stack.isEmpty()&&mono_stack.peek() == m-1){
                while(!mono_stack.isEmpty()){
                    int pre = mono_stack.pop();
                    ret = Math.max(ret, left[pre][i]*(m-up[pre]-1));
                }
            }
        }
        return ret;
    }
}
