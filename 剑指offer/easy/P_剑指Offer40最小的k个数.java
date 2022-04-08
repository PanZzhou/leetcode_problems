package com.pan.leetcode.剑指offer.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_剑指Offer40最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k>=arr.length) return arr;
        int[] ret = new int[k];
        if(k==0) return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i]<heap.peek()){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = heap.poll();
        }
        return ret;
    }
}
