package com.pan.leetcode.everyday;

public class P_36有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] grids = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int cur = board[i][j] - '0';
                    int item = 1<<cur;
                    if((item & rows[i]) != 0 || (item & cols[j]) != 0 || (item & grids[getGrid(i, j)]) != 0)
                        return false;
                    rows[i] |= item;
                    cols[j] |= item;
                    grids[getGrid(i,j)] |= item;
                }
            }
        }
        return true;
    }
    private int getGrid(int row, int col){
        int i = row/3, j = col/3;
        return i*3 + j;
    }
}
