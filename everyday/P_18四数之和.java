package com.pan.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        if(n < 4) return ret;
        Arrays.sort(nums);
        for (int i = 0; i < n-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < n-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1, high = n-1;
                while(low < high){
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[low]);
                        ans.add(nums[high]);
                        ret.add(ans);
                        low++;
                        while(low<high && nums[low] == nums[low-1]) low++;
                        high--;
                        while(low<high && nums[high] == nums[high+1]) high--;
                    }else if(sum > target){
                        high--;
                        while(low<high && nums[high] == nums[high+1]) high--;
                    }else{
                        low++;
                        while(low<high && nums[low] == nums[low-1]) low++;
                    }
                }
            }
        }
        return ret;
    }
}
