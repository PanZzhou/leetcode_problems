package com.pan.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class P_78子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res,ans,nums,0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> ans,int[] nums,int index){
        res.add(new ArrayList<>(ans));
        for (int i = index; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(res,ans,nums,i+1);
            ans.remove(ans.size()-1);
        }
    }
}
