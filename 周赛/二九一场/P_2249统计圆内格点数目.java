package com.pan.leetcode.周赛.二九一场;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_2249统计圆内格点数目 {
    public int countLatticePoints(int[][] circles) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int m = circles.length;
        int[] inx = new int[]{1,-1};
        int[] inx_single = new int[]{1};
        int ret = 0;
        for (int i = 0; i < m; i++) {
            int row = circles[i][0], col = circles[i][1], l = circles[i][2];
            for (int j = row-l; j <= row ; j++) {
                for (int k = col-l; k <= col; k++) {
                    int row_l = row - j, col_l = col -k;
                    if(Math.sqrt(row_l*row_l + col_l*col_l)<=l){
                        int[] row_inx = inx, col_inx = inx;
                        if(row_l == 0)
                            row_inx = inx_single;
                        if(col_l == 0)
                            col_inx = inx_single;
                        for (int level : row_inx) {
                            int real_row = level*(j-row)+row;
                            Set<Integer> cur = map.getOrDefault(real_row, null);
                            if(cur == null){
                                HashSet<Integer> localSet = new HashSet<>();
                                for (int column : col_inx) {
                                    localSet.add(column*(k-col)+col);
                                    ret++;
                                }
                                map.put(real_row, localSet);
                            }else{
                                for (int column : col_inx) {
                                    int real_col = column*(k-col)+col;
                                    if(!cur.contains(real_col)){
                                        cur.add(real_col);
                                        ret++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}
