package com.pan.leetcode.搜索;

import java.util.*;

public class P_934最短的桥 {
    int[] dx = new int[]{-1, 0, 1, 0, -1};
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<List<Integer>> land = new LinkedList<>();
        boolean finded = false;
        //先使用深度优先遍历找到其中一个岛，围着岛周围的水都被放进land队列中。
        for (int i = 0; i < m; i++) {
            if(finded) break;
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    dfs(grid, land, i, j);
                    finded = true;
                    break;
                }
            }
        }
        int x, y;
        int level = 0;
        //再使用广度优先遍历一圈一圈得向四周扩张以找到第二个岛，扩张的次数就代表两岛之间的最短路径
        while(!land.isEmpty()){
            ++level;
            int size = land.size();
            while(size-->0){
                List<Integer> front = land.poll();
                for (int i = 0; i < 4; i++) {
                    x = front.get(0) + dx[i];
                    y = front.get(1) + dx[i+1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length){
                        if(grid[x][y]==2)
                            continue;
                        if(grid[x][y]==1)
                            return level;
                        ArrayList<Integer> cor = new ArrayList<>();
                        cor.add(x);
                        cor.add(y);
                        land.offer(cor);
                        grid[x][y] = 2;
                    }
                }
            }
        }
        return level;
    }

    private void dfs(int[][] grid, Queue<List<Integer>> land, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==2) return;
        if(grid[i][j]==0){
            ArrayList<Integer> cor = new ArrayList<>();
            cor.add(i);
            cor.add(j);
            land.offer(cor);
            return;
        }
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            dfs(grid, land, i+dx[k], j+dx[k+1]);
        }
    }
}
