package com.pan.leetcode.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P_785判断二分图 {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;//染色记录，同时也当作是否访问过的记录。
    public boolean isBipartite(int[][] graph) {
//        return bfs(graph);
        return dfs(graph);
    }

    public boolean dfs(int[][] graph){
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; i++) {
            if(color[i]==UNCOLORED && !startDfs(graph, i, RED))
                return false;
        }
        return true;
    }

    public boolean startDfs(int[][] graph, int node, int DY){
        if(color[node]==UNCOLORED){
            color[node] = DY;
            int nextDY = DY == RED? GREEN:RED;
            for(int neighbor:graph[node]){
                if(color[neighbor]==UNCOLORED && !startDfs(graph, neighbor, nextDY))
                    return false;
                else if(color[neighbor] == DY)
                    return false;
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph){
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; i++) {
            if(color[i]==UNCOLORED){
                Deque<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    int oppo = color[node]==RED?GREEN:RED;
                    for(int neighbor:graph[node]){
                        if(color[neighbor]==UNCOLORED){
                            color[neighbor] = oppo;
                            queue.offer(neighbor);
                        }else if(color[neighbor]!=oppo)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
