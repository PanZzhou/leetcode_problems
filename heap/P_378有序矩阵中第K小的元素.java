package com.pan.leetcode.heap;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P_378有序矩阵中第K小的元素 {
    //归并两个数组很容易，归并n个数组就可以使用堆来减少时间复杂度。
    //这个方法比下面这个方法好多了
    public int kthSmallest(int[][] matrix, int k){
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);//最小堆
        int order=1;
        for(int i=0;i<matrix.length;i++){
            heap.offer(new int[]{matrix[i][0],i,0});
        }
        while(order++<k){
            int[] top = heap.poll();
            if(top[2]+1<matrix[0].length)
                heap.offer(new int[]{matrix[top[1]][top[2]+1],top[1],top[2]+1});
        }
        return heap.peek()[0];
    }
    //下面这个方法从左上角开始，空间复杂度太大达到n2
//    public int kthSmallest(int[][] matrix, int k) {
//        if(matrix==null)
//            return 0;
//        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
//        boolean isVisited[][] = new boolean[matrix.length][matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                isVisited[i][j]=false;
//            }
//        }
//        int index=1;
//        heap.offer(new int[]{matrix[0][0],0,0});
//        isVisited[0][0]=true;
//        while(index++<k){
//            int[] top = heap.poll();
//            if(top[1]+1<matrix.length&&!isVisited[top[1]+1][top[2]]){
//                heap.offer(new int[]{matrix[top[1]+1][top[2]],top[1]+1,top[2]});
//                isVisited[top[1]+1][top[2]]=true;
//            }
//            if(top[2]+1<matrix[0].length&&!isVisited[top[1]][top[2]+1]){
//                heap.offer(new int[]{matrix[top[1]][top[2]+1],top[1],top[2]+1});
//                isVisited[top[1]][top[2]+1]=true;
//            }
//        }
//        return heap.poll()[0];
//    }
}
