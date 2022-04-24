package com.pan.leetcode.剑指offerII.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_剑指Offer_II_007_数组中和为0的三个数 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int k = 0; k < nums.length-2; k++) {
            if(k>0 && nums[k]==nums[k-1])
                continue;
            if(nums[k]>0)
                break;
            int i = k+1, j = nums.length-1;
            while(i<j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[k]);
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ret.add(ans);
                    //while(i<j && nums[j] == nums[j-1]) j--;
                    j--;
                    while(j>i && nums[j] == nums[j+1]) j--;
                }else if(sum > 0){
                    j--;
                    while(j>i && nums[j] == nums[j+1]) j--;
                }
                else{
                    i++;
                    while(i<j && nums[i] == nums[i-1]) i++;
                }
            }
        }
        return ret;
    }
}
