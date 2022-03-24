package com.pan.leetcode.搜索;

import java.util.*;

public class P_310最小高度树 {
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<Integer> ret = new ArrayList<>();
//        if(edges.length == 0){
//            ret.add(0);
//            return ret;
//        }
//        boolean[] vis = new boolean[n];
//        Queue<Integer> queue = new ArrayDeque<>();
//
//        Map<Integer, List<Integer>> neighbor = new HashMap<>();
//        for (int i = 0; i < edges.length; i++) {
//            if(!neighbor.containsKey(edges[i][0])){
//                ArrayList<Integer> nei = new ArrayList<>();
//                nei.add(edges[i][1]);
//                neighbor.put(edges[i][0], nei);
//            }else
//                neighbor.get(edges[i][0]).add(edges[i][1]);
//            if(!neighbor.containsKey(edges[i][1])){
//                ArrayList<Integer> nei = new ArrayList<>();
//                nei.add(edges[i][0]);
//                neighbor.put(edges[i][1], nei);
//            }else
//                neighbor.get(edges[i][1]).add(edges[i][0]);
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(vis, false);
//            queue.clear();
//            queue.offer(i);
//            vis[i] = true;
//            int level = 0;
//            while(!queue.isEmpty()){
//                int size = queue.size();
//                level++;
//                if(level > min)
//                    break;
//                while(size-->0){
//                    int cur = queue.poll();
//                    List<Integer> nei = neighbor.get(cur);
//                    for (Integer from : nei) {
//                        if(vis[from])
//                            continue;
//                        queue.offer(from);
//                        vis[from] = true;
//                    }
//                }
//            }
//            if(level<=min){
//                if(level<min){
//                    min = level;
//                    ret.clear();
//                }
//                ret.add(i);
//            }
//        }
//        return ret;
//    }
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> ret = new ArrayList<>();
    if(edges.length==0){
        ret.add(0);
        return ret;
    }
    List<Integer> swap = new ArrayList<>();//用于保存ret上次的状态
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] degree = new int[n];
    boolean[] visited = new boolean[n];
    for (int[] edge : edges) {
        degree[edge[0]]++;
        degree[edge[1]]++;
        if(map.containsKey(edge[0]))
            map.get(edge[0]).add(edge[1]);
        else{
            ArrayList<Integer> from = new ArrayList<>();
            from.add(edge[1]);
            map.put(edge[0], from);
        }
        if(map.containsKey(edge[1]))
            map.get(edge[1]).add(edge[0]);
        else{
            ArrayList<Integer> from = new ArrayList<>();
            from.add(edge[0]);
            map.put(edge[1], from);
        }
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        if(degree[i]!=1)
            continue;
        queue.offer(i);
        visited[i] = true;
        swap.add(i);
    }
    List<Integer> temp;
    while(!queue.isEmpty()){
        temp = swap;
        swap = ret;
        ret = temp;
        swap.clear();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int cur = queue.poll();
            List<Integer> from = map.get(cur);
            degree[cur]--;
            for (Integer neighbour : from) {
                if(visited[neighbour])
                    continue;
                if(degree[neighbour]==2){
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                    swap.add(neighbour);
                }
                degree[neighbour]--;
            }
        }
    }
    return ret;
}
}
