package com.pan.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int first = 0;first<nums.length;++first){
            if(first>0&&nums[first-1]==nums[first])
                continue;
            int third = nums.length-1,target = -nums[first];
            for(int second = first + 1;second<nums.length;++second){
                if(second>first+1&&nums[second-1]==nums[second])
                    continue;
                while(second<third&&nums[third]+nums[second]>target)
                    --third;
                if(second==third)
                    break;
                if(nums[third]+nums[second]==target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
