package com.pan.leetcode.周赛.二九一场;

import java.util.Arrays;
import java.util.Comparator;

public class P_6043统计包含每个点的矩形数目 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = points.length, m = rectangles.length;
        int[] ret = new int[n];
        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]+o1[1]>o2[0]+o2[1])
                    return o1[0]+o1[1] - o2[0]+o2[1];
                if(o1[0] - o2[0] > 0)
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            int[] cur = points[i];
            int low = 0, high = m-1, mid = 0;
            while(low<=high){
                mid = (low+high)>>1;
                int[] target = rectangles[mid];
                if(target[0] + target[1] > cur[0]+cur[1] || target[0]>cur[0] || target[0]==cur[0] && target[1]>=cur[1]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            ret[i] = n - mid;
        }
        return ret;
    }
}
