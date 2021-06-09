package com.pan.leetcode.recursion;

public class P_52N皇后II {
    public int totalNQueens(int n) {
        return allQueens(n,0,0,0,0);
    }
    private int allQueens(int n,int row,int column,int diag1,int diag2){
        if(row==n)
            return 1;
        int availablePosition = ((1<<n)-1)&(~(column|diag1|diag2));
        int count = 0;
        while(availablePosition!=0){
            int position = availablePosition & (-availablePosition);
            availablePosition = availablePosition & (availablePosition - 1);
            int col = Integer.bitCount(position - 1);
            count += allQueens(n, row+1, column|position,(diag1|position)<<1,(diag2|position)>>1);
        }
        return count;
    }
}
