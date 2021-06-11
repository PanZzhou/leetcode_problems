package com.pan.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_451根据字符出现频率排序 {
    public String frequencySort(String s) {
        if(s.length()<=1)
            return s;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> heap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        heap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()){
            Map.Entry<Character, Integer> top = heap.poll();
            char key = top.getKey();
            int nums = top.getValue();
            while(nums-->0)
                sb.append(key);
        }
        return sb.toString();
    }
}
