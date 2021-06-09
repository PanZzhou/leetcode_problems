package com.pan.leetcode.recursion;

import java.util.*;

//class Solution {
//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        List<Integer> ans = new ArrayList<>();
//        all(nums,set,ans);
//
//        return res;
//    }
//
//    private void all(int[] nums, Set<Integer> index,List<Integer> ans){
//        if(ans.size()==nums.length){
//            res.add(new ArrayList<>(ans));
//            return;
//        }
//        for(int i=0;i<nums.length;i++){
//            if(!index.contains(i)){
//                index.add(i);
//                ans.add(nums[i]);
//                all(nums,index,ans);
//                ans.remove(ans.size()-1);
//                index.remove(i);
//            }
//        }
//    }
//}

public class P_46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);
        }
        backTrack(nums.length,ans,res,0);
        return res;
    }
    private void backTrack(int len,List<Integer> ans, List<List<Integer>> res, int first){
        if(first==len){
            res.add(new ArrayList<>(ans));
        }
        for(int i=first;i<len;i++){
            Collections.swap(ans,i,first);
            backTrack(len,ans,res,first+1);
            Collections.swap(ans,i,first);
        }
    }
}
