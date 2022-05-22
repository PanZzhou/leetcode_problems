package com.pan.leetcode.周赛.二九四场;

import java.util.Arrays;

public class P_6075装满石头的背包的最大数量 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int ret = 0, n = capacity.length;
        for (int i = 0; i < n; i++) {
            capacity[i] -= rocks[i];
            if(capacity[i] == 0)
                ret++;
        }
        Arrays.sort(capacity);
        for (int i = 0; i < n; i++) {
            if(capacity[i] != 0){
                if(additionalRocks >= capacity[i]) {
                    additionalRocks -= capacity[i];
                    capacity[i] = 0;
                    ret++;
                }else break;
            }
        }
        return ret;
    }
}
