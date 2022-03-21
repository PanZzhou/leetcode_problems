package com.pan.leetcode.搜索;

public class P_79单词搜索 {
    int dx[] = new int[]{-1, 0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        int m = board.length, n = board[0].length;
        if(m*n < word.length()) return false;
        //修改访问标记方式
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(exitSide(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }
    private boolean exitSide(char[][] board, String word, int inx, int i, int j, boolean[][] visited){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || inx>=word.length() || visited[i][j] || board[i][j] != word.charAt(inx)) return false;
        if(inx == word.length()-1) return true;
        boolean ret = false;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if(exitSide(board, word, inx+1, i+dx[k], j+dx[k+1], visited)){
                ret = true;
                break;
            }
        }
        visited[i][j] = false;
        return ret;
    }
}
