package com.pan.leetcode.搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_47全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        //n个空位，随机选取nums中的数依次填入
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);//把相等的数放在一起
        dfs(nums,visited,0, ret, ans);
        return ret;
    }
    private void dfs(int[] nums, boolean[] vis, int inx, List<List<Integer>> ret, List<Integer> ans){
        //填满之后，保存结果
        if(inx == nums.length){
            ret.add(new ArrayList<>(ans));
            return;
        }
        //每次填第inx个元素时，遍历一遍nums数组，选择不重复的数字放进结果
        for (int i = 0; i < nums.length; i++) {
            if(vis[i] || (i>0 && nums[i]==nums[i-1] && !vis[i-1]))
                continue;
            ans.add(nums[i]);
            vis[i] = true;
            dfs(nums,vis, inx+1, ret, ans);
            vis[i] = false;
            ans.remove(inx);//移除这个数
        }
    }
}
