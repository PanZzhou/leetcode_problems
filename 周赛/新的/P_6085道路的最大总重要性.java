package com.pan.leetcode.周赛.新的;

import java.util.*;

public class P_6085道路的最大总重要性 {
    //怎么维护最大的
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int i = 0; i < roads.length; i++) {
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }
        long ret = 0;
        Arrays.sort(degree);
        for (int i = 0; i < n; i++) {
            ret = ret + (long)(i+1)*degree[i];
        }
        return ret;
    }
}
