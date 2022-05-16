package com.pan.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class P_39组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        dfs(candidates,res,candidate,target,0);

        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> candidate, int target, int index){
        if(index>=candidates.length){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(candidate));
            return;
        }
        //跳过当前数
        dfs(candidates,res,candidate,target,index+1);
        if(target-candidates[index]>=0){
            //选择或者重复选择当前数
            candidate.add(candidates[index]);
            dfs(candidates,res,candidate,target-candidates[index],index);
            candidate.remove(candidate.size()-1);
        }
    }
}
