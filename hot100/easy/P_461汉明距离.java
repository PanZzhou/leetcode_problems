package com.pan.leetcode.hot100.easy;

public class P_461汉明距离 {
    public int hammingDistance(int x, int y) {
        int lowX, lowY, ret = 0;
        while(x!=0 || y!= 0){
            if(x == 0){
                while(y != 0){
                    y &= (y-1);
                    ret++;
                }
                break;
            }
            if(y == 0){
                while( x!= 0){
                    x &= (x - 1);
                    ret++;
                }
                break;
            }
            lowX = x & (-x);
            lowY = y & (-y);
            if(lowX == lowY){
                x &= (x - 1);
                y &= (y - 1);
            }else if(lowX > lowY){
                y &= (y - 1);
                ret++;
            }else{
                x &= (x - 1);
                ret++;
            }
        }
        return ret;
    }
}
