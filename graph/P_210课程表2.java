package com.pan.leetcode.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//拓扑排序
public class P_210课程表2 {
    private List<List<Integer>> edges;
    private int[] indeg;
    private int[] result;
    private int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for(int[] info:prerequisites){//这里有一个构造邻接表的过程。
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indeg[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            result[index++] = node;
            for(int v:edges.get(node)){
                --indeg[v];
                if(indeg[v] == 0)
                    queue.offer(v);
            }
        }
        if(index!=numCourses)
            return new int[0];
        return result;
    }
}
