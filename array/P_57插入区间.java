package com.pan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class P_57插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left=newInterval[0],right=newInterval[1];
        List<int[]> res = new ArrayList<>();
        boolean hasPlaced = false;
        for (int[] interval : intervals) {
            if(right<interval[0]){
                if(!hasPlaced){
                    res.add(new int[]{left,right});
                    hasPlaced=true;
                }
                res.add(interval);
            }else if(left>interval[1])
                res.add(interval);
            else{
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if(!hasPlaced)
            res.add(new int[]{left,right});
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
