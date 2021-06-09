package com.pan.leetcode.double_pointer;

public class P_11盛最多水 {
    public int maxArea(int[] height) {
        int low = 0, high = height.length-1;
        int area = 0,res = 0;
        while(low<high){
            boolean isLow = height[low]<=height[high];
            area = (isLow?height[low]:height[high])*(high-low);
            if(area>res)
                res = area;
            if(isLow)
                low++;
            else
                high--;
        }
        return res;
    }
}
