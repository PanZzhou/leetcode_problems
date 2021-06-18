package com.pan.leetcode.剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_剑指Offer04二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if(row<=0)
            return false;
        int col = matrix[0].length;
        if(col<=0)
            return false;
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < row; i++) {
            heap.offer(new int[]{matrix[i][0],i,0});
        }
        while(!heap.isEmpty()){
            int[] top = heap.poll();
            if(top[0]==target)
                return true;
            else if(top[0]>target)
                return false;
            else{
                if(top[2]+1<col)
                    heap.offer(new int[]{matrix[top[1]][top[2]+1],top[1],top[2]+1});
            }
        }
        return false;
    }
}
