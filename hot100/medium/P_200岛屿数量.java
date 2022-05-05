package com.pan.leetcode.hot100.medium;

public class P_200岛屿数量 {
    public int numIslands(char[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ret++;
                }
            }
        }
        return ret;
    }
    private void dfs(char[][] grid, int i, int j){
        if(grid[i][j] != '1') return;
        grid[i][j] = '2';
        if(i>0)
            dfs(grid, i-1, j);
        if(j>0)
            dfs(grid, i, j-1);
        if(i<grid.length-1)
            dfs(grid, i+1, j);
        if(j<grid[0].length - 1)
            dfs(grid, i, j+1);
    }
}
