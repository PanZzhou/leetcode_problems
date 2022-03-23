package com.pan.leetcode.搜索;

public class P_130被围绕的区域 {
    int[] dx = new int[]{-1,0,1,0,-1};
    char open = '1';
    char land = 'X';
    char water = 'O';
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(board[i][j]==water){
                        dfs(board, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==water)
                    board[i][j] = land;
                else if(board[i][j]==open)
                    board[i][j] = water;
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != water) return;
        board[i][j] = open;
        for (int k = 0; k < 4; k++) {
            dfs(board, i+dx[k], j+dx[k+1]);
        }
    }
}
