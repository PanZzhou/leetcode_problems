package com.pan.leetcode.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_347前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mMap = new HashMap<>();
        //map记录元素个数固定写法
        for (int num : nums) {
            mMap.put(num, mMap.getOrDefault(num, 0) + 1);
        }
        //优先队列构造一个小顶堆，其元素是一个Map.Entry，因为上面使用map记录元素个数了
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            //大于零，升序，小于零，降序
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //大于零，就交换，小于0，就不交换
                return o1.getValue() - o2.getValue();
            }
        });
        //遍历map的方式
        for (Map.Entry<Integer, Integer> entry : mMap.entrySet()) {
            if(minHeap.size() < k)
                minHeap.offer(entry);
            else if(minHeap.peek().getValue() < entry.getValue()){
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
