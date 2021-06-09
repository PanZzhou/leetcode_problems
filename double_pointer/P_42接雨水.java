package com.pan.leetcode.double_pointer;

public class P_42接雨水 {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int res = 0;
        int left_max = 0, right_max = 0;
        while(left<right){
            if(height[left]>=height[right]){
                if(right_max<height[right])
                    right_max = height[right];
                else{
                    res += right_max - height[right];
                }
                right--;
            }else {
                if(left_max<height[left])
                    left_max = height[left];
                else
                    res += left_max - height[left];
                left++;
            }
        }
        return res;
    }
}
