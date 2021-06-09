package com.pan.leetcode.array;

import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_56合并区间 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int index = 0;
        List<Integer> rows = new ArrayList<>();
        rows.add(0);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>intervals[index][1]){
                index = i;
                rows.add(i);
            }else{
                intervals[index][1] = Math.max(intervals[index][1],intervals[i][1]);
            }
        }
        index = rows.size();
        int[][] res = new int[index][2];
        for (int i = 0; i < index; i++) {
            res[i] = intervals[rows.get(i)];
        }
        return res;
    }
}
