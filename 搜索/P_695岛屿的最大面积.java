package com.pan.leetcode.搜索;

import java.util.LinkedList;
import java.util.Queue;

public class P_695岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
//        return maxAreaOfIslandBfs(grid);
        return maxAreaOfIslandDfs(grid);
    }

    public int maxAreaOfIslandBfs(int[][] grid){
        int ret = 0;
        //广度优先遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = 0;
                Queue<Integer> rowQ = new LinkedList<>();
                Queue<Integer> colQ = new LinkedList<>();
                rowQ.offer(i);
                colQ.offer(j);
                while(!rowQ.isEmpty()){
                    int cur_i = rowQ.poll(), cur_j = colQ.poll();
                    if(cur_i < 0 || cur_j < 0 || cur_i >= grid.length || cur_j >= grid[0].length || grid[cur_i][cur_j]==0) continue;
                    cur++;
                    //已访问过的元素置零，避免再次访问
                    grid[cur_i][cur_j] = 0;
                    int[] di = new int[]{1, 0, -1, 0};
                    int[] dj = new int[]{0, 1, 0, -1};
                    for (int k = 0; k < 4; k++) {
                        int nei_i = cur_i + di[k], nei_j = cur_j + dj[k];
                        rowQ.offer(nei_i);
                        colQ.offer(nei_j);
                    }
                }
                ret = Math.max(ret, cur);
            }
        }
        return ret;
    }

    public int maxAreaOfIslandDfs(int[][] grid){
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ret = Math.max(ret, maxAreaOfIslandDfs(grid, i, j));
            }
        }
        return ret;
    }

    public int maxAreaOfIslandDfs(int[][] grid, int i, int j) {
        if(i < 0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0)
            return 0;
        int cur = 1;
        grid[i][j] = 0;
        cur += maxAreaOfIslandDfs(grid, i-1, j);
        cur += maxAreaOfIslandDfs(grid, i+1, j);
        cur += maxAreaOfIslandDfs(grid, i, j-1);
        cur += maxAreaOfIslandDfs(grid, i, j+1);
        return cur;
    }
}
