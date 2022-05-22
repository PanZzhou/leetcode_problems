package com.pan.leetcode.周赛.二九四场;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class P_6076表示一个折线图的最少线段数 {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if(n <= 1) return 0;
        if(n == 2) return 1;
        Arrays.sort(stockPrices, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        BigDecimal preday = BigDecimal.valueOf(stockPrices[1][0] - stockPrices[0][0]);
        BigDecimal preprice = BigDecimal.valueOf(stockPrices[1][1] - stockPrices[0][1]);
        BigDecimal curday, curprice,cur, pre = preprice.divide(preday,20,BigDecimal.ROUND_HALF_UP);
        int ret = 1;
        for (int i = 2; i < n; i++) {
            curday = BigDecimal.valueOf(stockPrices[i][0] - stockPrices[i-1][0]);
            curprice = BigDecimal.valueOf(stockPrices[i][1] - stockPrices[i-1][1]);
            cur = curprice.divide(curday, 20, BigDecimal.ROUND_HALF_UP);
            if(!pre.equals(cur)){//改除法变为乘法！我操了，这个地方浪费了一个小时。大无语事件
                ret++;
                pre = cur;
            }
        }
        return ret;
    }

//    public int minimumLines(int[][] stockPrices) {
//        int n = stockPrices.length;
//        if(n <= 1) return 0;
//        if(n == 2) return 1;
//        Arrays.sort(stockPrices, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        int preday = stockPrices[1][0] - stockPrices[0][0], preprice = stockPrices[1][1] - stockPrices[0][1], curday, curprice;
//        int ret = 1;
//        double diff = 1.79e-300;
//        for (int i = 2; i < n; i++) {
//            curday = stockPrices[i][0] - stockPrices[i-1][0];
//            curprice = stockPrices[i][1] - stockPrices[i-1][1];
//            if(preprice*curday != curprice*preday){//改除法变为乘法！我操了，这个地方浪费了一个小时。大无语事件
//                ret++;
//                preday = curday;
//                preprice = curprice;
//            }
//        }
//        return ret;
//    }
}
