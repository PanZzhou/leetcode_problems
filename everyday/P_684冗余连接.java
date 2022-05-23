package com.pan.leetcode.everyday;

import java.util.*;

public class P_684冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
         int n = edges.length;
         int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int pre = edges[i][0], post = edges[i][1];
            int prePat = findParent(parent, pre);
            int postPat = findParent(parent, post);
            if(prePat != postPat)
                parent[postPat] = prePat;
            else//如果两个点具有相同的祖先，那么再添加这两个点间的线段的话，就一定会导致出现环！
                return edges[i];
        }
        return null;
    }
    private int findParent(int[] parent, int cur){
        if(cur != parent[cur])
            return findParent(parent, parent[cur]);
        return parent[cur];
    }
//    private void unionParent(int[] parent, int pre, int post){
//        parent[findParent(parent, post)] = findParent(parent, pre);
//    }
}
