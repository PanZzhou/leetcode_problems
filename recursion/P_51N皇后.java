package com.pan.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_51N皇后 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //用一个数列记录n*n矩阵中皇后得放置位置
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        solve(res, queens, n, 0, 0, 0, 0);
        return res;
    }

    private void solve(List<List<String>> res, int[] queens,int n, int row, int column,int diag1, int diag2){
        if(n==row){
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] temp = new char[n];
                Arrays.fill(temp, '.');
                temp[queens[i]] = 'Q';
                ans.add(new String(temp));
            }
            res.add(ans);
        }else{
            int availablePosition = ((1<<n)-1)&(~(column|diag1|diag2));
            while(availablePosition!=0){
                int position = availablePosition & (-availablePosition);    //获取最低位为1的位置
                availablePosition = availablePosition&(availablePosition-1);    //最低位的1置为零。
                int col = Integer.bitCount(position-1); //获取列号
                //递归回溯前记录回溯状态
                queens[row] = col;
                solve(res,queens,n,row+1,(column | position),(diag1|position)<<1,(diag2|position)>>1);
                //递归结束后复原回溯前的状态
                queens[row] = -1;
            }
        }
    }
}
