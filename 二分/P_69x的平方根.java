package com.pan.leetcode.二分;

public class P_69x的平方根 {
    public int mySqrt(int x) {
        if(x<2) return x;
        int low = 0, high = x, mid = 0, ret = -1;
        while(low<=high){
            mid = (low+high)>>1;
            if((long)mid * mid<=x){
                low = mid+1;
                ret =  mid;
            }
            else
                high = mid-1;
        }
        return ret;
    }
}
