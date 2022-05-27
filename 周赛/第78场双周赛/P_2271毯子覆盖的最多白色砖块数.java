package com.pan.leetcode.周赛.第78场双周赛;

import java.util.Arrays;
import java.util.Comparator;

public class P_2271毯子覆盖的最多白色砖块数 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length;
        int ret = 0;
        Arrays.sort(tiles, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[] holes = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            if(i==0)
                holes[i] = tiles[i+1][0] - tiles[i][1] - 1;
            else
                holes[i] = holes[i-1] + tiles[i+1][0] - tiles[i][1] - 1;//累加空洞值
        }
        for (int i = 0; i < n; i++) {
            int left = tiles[i][0], right = tiles[i][1];
            if(right - left + 1 >= carpetLen)
                return carpetLen;
            //找出此区域有多少空洞，二分：
            int holenum = getHoles(tiles, holes, left + carpetLen - 1);//第i个
            if(i>0)
                holenum -= holes[i-1];
            ret = Math.max(ret, carpetLen - holenum);
//            System.out.println(holenum+" "+ret);
        }
        return ret;
    }
    private int getHoles(int[][] tiles, int[] holes, int target){
        int ret = 0;
        int left = 0, right = tiles.length-1, mid, inx = 0;
        while(left<=right){
            mid = (right+right)>>1;
            int redge = tiles[mid][1];
            int ledge = tiles[mid][0];
            if(target>=ledge && target<=redge){
                if(mid == 0) return  0;
                else return holes[mid-1];
            }else if(target > redge){
                inx = mid;
                left = mid + 1;
            }else
                right = mid - 1;
        }
        ret += target - tiles[inx][1];
        if(inx > 0){
            ret += holes[inx-1];
        }
        return ret;
    }
}
