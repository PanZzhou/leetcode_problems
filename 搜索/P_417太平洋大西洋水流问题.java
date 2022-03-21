package com.pan.leetcode.搜索;

import java.util.ArrayList;
import java.util.List;

public class P_417太平洋大西洋水流问题 {
    List<List<Integer>> ret = new ArrayList<>();
    int[] dr = new int[] {-1, 0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ret.clear();
        int m = heights.length, n = heights[0].length;
        int[][] canReach = new int[m][n];//1表示太平洋can reach 2表示大西洋can reach  3表示都能can reach
        //对每一个元素进行深度搜索的话，导致变得很复杂
        //可以使用逆向思维，从岛的四周向岛中心逆流而上，
        for (int i = 0; i < m; i++) {
            dfs(heights, canReach, i, 0, 1);
            dfs(heights, canReach, i, n-1, 2);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, canReach, 0, i, 1);
            dfs(heights, canReach, m-1, i, 2);
        }
        return ret;
    }

    private void dfs(int[][] heights, int[][] canReach, int i, int j, int type){
        if(canReach[i][j] == type || canReach[i][j] == 3)
            return;
        if(canReach[i][j] == 0)
            canReach[i][j] = type;
        else{
            canReach[i][j] = 3;
            ArrayList<Integer> r = new ArrayList<>();
            r.add(i);
            r.add(j);
            ret.add(r);
        }
        for (int k = 0; k < 4; k++) {
            int row = i + dr[k], col = j + dr[k+1];
            if(row >= 0 && col >=0 && row < heights.length && col < heights[0].length && heights[i][j] <= heights[row][col])
                dfs(heights, canReach, row, col, type);
        }
    }
}
