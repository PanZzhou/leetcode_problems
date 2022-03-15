package com.pan.leetcode.搜索;

public class P_547省份数量 {
    //也就是深度有限遍历,连通图的个数
    public int findCircleNum(int[][] isConnected) {
        int cityNum = 0;
        //用于标记有没有访问，n个结点
        boolean[] isVisited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if(!isVisited[i]){
                dfs(isConnected, isVisited, i);
                cityNum++;
            }
        }
        return cityNum;
    }
    private void dfs(int[][] isConnected, boolean[] isVisited, int city){
        for (int i = 0; i < isConnected[city].length; i++) {
            if(isConnected[city][i] == 1 && !isVisited[i]){
                isVisited[i] = true;
                dfs(isConnected, isVisited, i);
            }
        }
    }
}
