package com.pan.leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_347前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(minHeap.size()<k)
                minHeap.offer(entry);
            else if(minHeap.peek().getValue()<entry.getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = minHeap.poll().getKey();
        }
        return ret;
    }
}
