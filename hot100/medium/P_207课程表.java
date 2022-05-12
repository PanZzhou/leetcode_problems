package com.pan.leetcode.hot100.medium;

import java.util.*;

public class P_207课程表 {
    List<List<Integer>> edges;
    int[] visted;
    boolean canFi = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visted = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());//注意这种需要先实例化每个元素才行
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][1], pre = prerequisites[i][0];
            edges.get(cur).add(pre);
        }
        //全部图的深度优先遍历方法
        for (int i = 0; i < numCourses && canFi; i++) {
            if(visted[i] == 0)
                dfs(i);
        }
        return canFi;
    }
    private void dfs(int v){
        visted[v] = 1;//标记为正在搜索当前节点
        for (int cur : edges.get(v)) {
            if(visted[cur] == 0){
                dfs(cur);
                if(!canFi) return;//在此处截断接下来的遍历操作
            }else if(visted[cur] == 1){
                canFi = false;
                return;
            }
        }
        visted[v] = 2;//标记为已经搜索完毕当前节点
    }
}
