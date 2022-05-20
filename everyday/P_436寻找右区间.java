package com.pan.leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;

public class P_436寻找右区间 {
    //怎么在数组中找大小自己最近的数？
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ret = new int[n];
        if(n == 1){
            ret[0] = -1;
            return ret;
        }
        //后面需要对ans排序，需要使用Comparator，而其元素必须是对象，所以用Integer而非int
        Integer[] ans = new Integer[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;//ans存储原始的intervals下标
        }
        //根据instervals[i][0]对ans排序，而非对intervals本身进行排序
        Arrays.sort(ans, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return intervals[o1][0] - intervals[o2][0];
            }
        });
        for (int i = 0; i < n; i++) {
            int inx = ans[i]; //原始下标
            int cur = intervals[inx][1];
            int left = 0, right = n-1, result = -1;
            while(left <= right){
                int mid = (left + right)>>1;
                if(cur <= intervals[ans[mid]][0]){
                    result = mid;
                    right = mid - 1;
                }else
                    left = mid + 1;
            }
            if(result!=-1){
                ret[inx] = ans[result];
            }else
                ret[inx] = -1;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ret[i]+" ");
        }
        System.out.println();
        return ret;
    }
}
