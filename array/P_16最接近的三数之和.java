package com.pan.leetcode.array;

import java.util.Arrays;

public class P_16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if(len<=2)
            return 0;
        Arrays.sort(nums); //先排序
        int res = target>=0?Integer.MAX_VALUE:Integer.MAX_VALUE-Math.abs(target);
        for(int first = 0;first<len;++first){
            int low = first + 1;
            int high = len - 1;
            int sum = 0;
            while(low<high){
                sum = nums[low]+nums[high]+nums[first];
                if(Math.abs(sum-target)<Math.abs(res-target))
                    res=sum;
                if(sum>target)
                    --high;
                else if(sum<target)
                    ++low;
                else
                    return target;
            }
        }
        return res;
    }
}
